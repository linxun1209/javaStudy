package com.面试中的算法.去哪儿.去哪儿2023春招;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 12:20
 */
public class Main1 {
    public int maxScore (int energy, int[][] actions) {
        // write code here
        int[] dp=new int[energy+1];
        dp[0]=0;
        for (int i = 0; i < actions.length; i++) {
            int a=actions[i][0];
            int b=actions[i][1];
            for (int j = energy; j>=actions.length; j--) {
                dp[j]=Math.max(dp[j],dp[j-a]+b);
            }
        }
        return dp[energy];
    }
}

