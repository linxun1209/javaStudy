package com.linxun.leetcode.代码随想录.动态规划;

import com.xingchen.Test.Main;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/9 22:06
 */
public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int max=Integer.MAX_VALUE;
        int[] dp=new int[amount+1];
        for(int j=0;j<dp.length;j++){
            dp[j]=max;
        }
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=max){
                    dp[j]= Math.min(dp[j],dp[j-coins[i]]+1);
                }

            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
