package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/9 17:01
 */
public class findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum = 0, zeroNum = 0;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = m; i <= oneNum; i--) {
                for (int j = n; j <= zeroNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - oneNum][j - zeroNum] + 1);
                }
            }

        }
        return dp[m][n];
    }

}
