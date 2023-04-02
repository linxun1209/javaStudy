package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/2 12:52
 */
public class minScoreTriangulation {

    public static void main(String[] args) {
        int[]  values={1,3,1,4,1,5};
        minScoreTriangulation(values);

    }



    public static int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int l = 0; l < n - len; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + values[l] * values[k] * values[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
