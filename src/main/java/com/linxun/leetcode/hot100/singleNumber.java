package com.linxun.leetcode.hot100;

import java.util.Arrays;

public class singleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i += 2) {
            if (i == n - 1)
                return nums[n - 1];
            if (nums[i] != nums[i + 1])
                return nums[i];

        }
        return -1;

    }


    /**
     * 异或
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}