package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/15 19:31
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int res=nums[0];
        for(int i=0;i<nums.length;i++){
            if(sum>0) {
                sum+=nums[i];
            } else {
                sum=nums[i];
            }
            res=Math.max(res,sum);

        }
        return res;

    }

    public static int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }

}
