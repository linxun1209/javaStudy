package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/16 22:57
 */
public class minDifficulty {
    int[][] g;
    Integer[][] memo;
    int INF = 0x3f3f3f3f;

    public int minDifficulty(int[] JD, int d) {
        int n = JD.length;
        if (n < d) {
            return -1;
        }
        if (n == d) {
            return Arrays.stream(JD).sum();
        }
        if (d == 1) {
            return Arrays.stream(JD).max().getAsInt();
        }
        g = new int[n][n];
        memo = new Integer[d + 1][n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, JD[j]);
                g[i][j] = max;
            }
        }
        return dfs(d, n - 1);
    }

    private int dfs (int days, int end) {
        if (days > end + 1) {
            return INF;
        }
        if (days == 1) {
            return g[0][end];
        }
        if (memo[days][end] != null) {
            return memo[days][end];
        }
        int res = INF;
        for (int i = end - 1; i >= 0; i--) {
            res = Math.min(res, dfs(days - 1, i) + g[i + 1][end]);
        }
        return memo[days][end] = res;
    }

    public int minDifficulty2(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            int u = 0;
            for (int j = i; j < n; j++) {
                u = Math.max(u, jobDifficulty[j]);
                max[i][j] = u;
            }
        }
        int[][] dp = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
            dp[i][1] = max[0][i];
        }
        for (int day = 2; day <= d; day++) {
            for (int j = 1; j < n; j++) {
                for (int i = j - 1; i >= 0; i--) {
                    dp[j][day] = Math.min(dp[j][day], dp[i][day - 1] + max[i + 1][j]);
                }
            }
        }
        return dp[n - 1][d];
    }

}
