package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/9 12:52
 */
public class findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int le = nums.length;
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        // 如果sum<target,即都为正数也不能组成target，则直接返回0
        if(sum < target || (sum - target) % 2 == 1) {
            return 0;
        }
        int X = (sum - target) / 2;     // 负数组的和为X，这里不能用正数组，因为target可能是负数
        int[] dp = new int[X + 1];
        dp[0] = 1;

        for(int num : nums) {
            for(int i = X; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];    // 负数组选num（dp[i-num]）和不选num（dp[i]）的数量相加为dp[i]
            }
        }
        return dp[X];
    }


    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            //如果target过大 sum将无法满足
            if ( target < 0 && sum < -target) {
                return 0;
            }
            if ((target + sum) % 2 != 0) {
                return 0;
            }
            int size = (target + sum) / 2;
            if(size < 0) {
                size = -size;
            }
            int[] dp = new int[size + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = size; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[size];
        }
    }
}
