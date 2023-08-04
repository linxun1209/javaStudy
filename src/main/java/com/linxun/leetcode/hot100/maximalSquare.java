package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/18 11:18
 */
public class maximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        if(m==1&&matrix[0][1]==0){
            return  0;
        }
        int max=1;
        int[][] dp=new int[m+1][n+1];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                max=Math.max(max,dp[i][j]);
            }
        }



        return max*max;
    }
}
