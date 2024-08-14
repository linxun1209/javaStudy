package com.linxun.leetcode.面试经典150题.二分查找;

import java.util.Arrays;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 719. 找出第 K 小的数对距离
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 *
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 *
 *
 * @date 2024/8/14 21:23
 */
public class smallestDistancePair {

    public static void main(String[] args) {
        System.out.println(smallestDistancePair2(new int[]{1, 1, 3, 4, 5}, 2));
    }


    /**
     * 排序 + 二分查找
     *
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    /**
     * 排序 + 二分查找 + 双指针
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

