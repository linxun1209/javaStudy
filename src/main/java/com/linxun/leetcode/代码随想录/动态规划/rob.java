package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/10 22:13
 */
public class rob {
    public int rob(int[] nums) {
        //动态规划
        int n=nums.length;
        if(n<=1){
            return n==0?0:nums[0];
        }
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
