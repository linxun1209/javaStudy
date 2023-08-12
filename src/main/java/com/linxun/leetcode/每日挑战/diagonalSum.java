package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/11 8:16
 */
public class diagonalSum {
    public int diagonalSum(int[][] mat) {
        int n=mat.length,ans=0;
        for (int i=0;i<n;i++){
            ans+=mat[i][i]+mat[i][n-i-1];

        }
        return ans%2==0?ans:ans-mat[n/2][n/2];

    }
}
