package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/22 11:05
 */
public class longestArithSeqLength {
    public int longestArithSeqLength(int[] A) {
        int m = A.length;
        //dp[i][j] 表示到第i个数 且公差为j的最长值
        int[][] dp = new int[m][20002];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i-1; j >= 0; j--) {
                int a = A[i] - A[j];
                if (a<0){
                    dp[i][1000 + a * -1] = Math.max(dp[j][1000 + a * -1] + 1, dp[i][1000 + a * -1]);
                    res = Math.max(res, dp[i][1000 + a * -1]);
                } else{
                    dp[i][a] = Math.max(dp[j][a] + 1,dp[i][a]);
                    res = Math.max(dp[i][a], res);
                }
            }
        }
        return res+1;
    }
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int minv = Arrays.stream(nums).min().getAsInt();
            int maxv = Arrays.stream(nums).max().getAsInt();
            int diff = maxv - minv;
            int ans = 1;
            for (int d = -diff; d <= diff; ++d) {
                int[] f = new int[maxv + 1];
                Arrays.fill(f, -1);
                for (int num : nums) {
                    int prev = num - d;
                    if (prev >= minv && prev <= maxv && f[prev] != -1) {
                        f[num] = Math.max(f[num], f[prev] + 1);
                        ans = Math.max(ans, f[num]);
                    }
                    f[num] = Math.max(f[num], 1);
                }
            }
            return ans;
        }
    }
}
