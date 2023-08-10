package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/10 21:05
 */
public class minFallingPathSum {
    public static void main(String[] args) {
        int[][] g={{1,2,3},{4,5,6},{7,8,9}};
        minFallingPathSum(g);
    }
    public static int minFallingPathSum(int[][] grid) {
        if(grid.length==1){
            return grid[0][0];
        }
        for (int i=1;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int min=Integer.MAX_VALUE;
                for (int k=0;k<grid.length;k++){
                    if(k!=j){
                        min=Math.min(grid[i-1][k],min);
                    }
                }
                grid[i][j]+=min;
            }
        }
        int res=Integer.MAX_VALUE;
        for (int i=0;i<grid.length;i++){
            res=Math.min(res,grid[grid.length-1][i]);
        }
        return res;
    }

    public int minFallingPathSum2(int[][] dp) {
        int n = dp.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] += min;
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }


    /**
     * 动态规划
     * @param grid
     * @return
     */
    public int minFallingPathSum3(int[][] grid) {
        int n = grid.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            d[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    d[i][j] = Math.min(d[i][j], d[i - 1][k] + grid[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, d[n - 1][j]);
        }
        return res;
    }


}
