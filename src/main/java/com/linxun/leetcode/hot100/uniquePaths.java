package com.linxun.leetcode.hot100;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/9 17:58
 */
public class uniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else {
                    //每一个位置都可以选择向下或者向右，即i-1代表上一个，j-1代表左边的那一个
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }


    /**
     * 代码优化
     * 空间复杂度 O(2n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }


    /**
     * 代码优化2
     * 空间复杂度 O(n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths4(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    /**
     * 排列组合方法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        //只跟第几行第几列有关，从m+n-2步中抽出m-1步
        long ans=1;
        for(int i=0;i<Math.min(m-1,n-1);i++){
            ans*=m+n-2-i;
            ans/=i+1;
        }
        return (int)ans;
    }
}
