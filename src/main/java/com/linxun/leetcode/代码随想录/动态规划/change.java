package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/9 17:23
 */
public class change {
    public static void main(String[] args) {
        int account=5;
        int[] coins={1, 2, 5};
        change3(account,coins);
    }

    public int change(int amount, int[] coins) {
        int len=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];

    }


        public int change2(int amount, int[] coins) {
            //递推表达式
            int[] dp = new int[amount + 1];
            //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            return dp[amount];
        }

    public static int change3(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        // 只有一种硬币的情况
        for (int i = 0; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 第i种硬币使用0~k次，求和
                for (int k = 0; k * coins[i] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}
