package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/7 15:56
 */
public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1){
            return cost[0];
        }
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);

        }
        return dp[dp.length-1];

    }
}
