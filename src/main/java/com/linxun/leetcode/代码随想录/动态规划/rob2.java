package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/11 11:48
 */
public class rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(A(nums, 0, len - 1), A(nums, 1, len));
    }

    public int A(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;

        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}
