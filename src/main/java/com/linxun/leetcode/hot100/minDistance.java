package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/12 10:26
 */
public class minDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        minDistance(word1,word2);
    }

    /**
     * 删除就是dp[i - 1][j] + 1，
     * 增加可以理解为删除另一个，也就是dp[i][j - 1] + 1，
     * 替换就是dp[i - 1][j - 1] + 1
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            dp[i][0]=i;
        }
        for (int j=1;j<=n;j++){
            dp[0][j]=j;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }
            }
        }return dp[m][n];

    }
}
