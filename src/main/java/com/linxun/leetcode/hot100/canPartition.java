package com.linxun.leetcode.hot100;

public class canPartition {

    public boolean canPartition(int[] nums) {
        if (nums.length > 2) {
            return false;
        }
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = w; j >= i; j++) {
                dp[j] += dp[j - i];
            }
        }
        return dp[w] != 0;
    }
    public boolean canPartition2(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++) {
            for(int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
