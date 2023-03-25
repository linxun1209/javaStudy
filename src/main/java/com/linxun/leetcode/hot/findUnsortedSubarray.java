package com.linxun.leetcode.hot;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/25 20:22
 */
public class findUnsortedSubarray {
    public static void main(String[] args) {
        int[] arr={2,6,4,8,10,9,15};
        findUnsortedSubarray(arr);
    }


    /**
     * 如果最右端的一部分已经排好序，这部分的每个数都比它左边的最大值要大，
     * 同理，如果最左端的一部分排好序，这每个数都比它右边的最小值小。
     * 所以我们从左往右遍历，如果i位置上的数比它左边部分最大值小，则这个数肯定要排序，
     * 就这样找到右端不用排序的部分，同理找到左端不用排序的部分，它们之间就是需要排序的部分
     * @param arr
     * @return
     */
    public static int findUnsortedSubarray(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]) {
                R = i;
            }
            max = Math.max(max, arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(min < arr[i]) {
                L = i;
            }
            min = Math.min(min, arr[i]);
        }
        return R == L ? 0 : R - L + 1;
    }


    /**
     * 排序法
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 一次排序
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray3(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}