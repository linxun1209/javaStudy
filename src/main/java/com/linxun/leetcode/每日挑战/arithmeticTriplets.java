package com.linxun.leetcode.每日挑战;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/31 15:30
 */
public class arithmeticTriplets {
    public static void main(String[] args) {

    }


    /**
     * 暴力法
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] - nums[j] == diff) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }


    /**
     *桶计数
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets2(int[] nums, int diff) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] count = new int[210];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 200; i >= 2 * diff; i--) {
            if (count[i] > 0 && count[i - diff] > 0 && count[i - diff - diff] > 0) {
                res++;
            }
        }
        return res;
    }


    /**
     * 哈希集合
     *
     */

    public int arithmeticTriplets3(int[] nums, int diff) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        int ans = 0;
        for (int x : nums) {
            if (set.contains(x + diff) && set.contains(x + 2 * diff)) {
                ans++;
            }
        }
        return ans;
    }


    public int arithmeticTriplets4(int[] nums, int diff) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0, j = 1, k = 2; i < n - 2 && j < n - 1 && k < n; i++) {
            j = Math.max(j, i + 1);
            while (j < n - 1 && nums[j] - nums[i] < diff) {
                j++;
            }
            if (j >= n - 1 || nums[j] - nums[i] > diff) {
                continue;
            }
            k = Math.max(k, j + 1);
            while (k < n && nums[k] - nums[j] < diff) {
                k++;
            }
            if (k < n && nums[k] - nums[j] == diff) {
                ans++;
            }
        }
        return ans;
    }



}
