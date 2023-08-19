package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/18 14:06
 */
public class maxSizeSlices {
    public int maxSizeSlices(int[] slices) {
        int[] v1 = new int[slices.length - 1];
        int[] v2 = new int[slices.length - 1];
        System.arraycopy(slices, 1, v1, 0, slices.length - 1);
        System.arraycopy(slices, 0, v2, 0, slices.length - 1);
        int ans1 = calculate(v1);
        int ans2 = calculate(v2);
        return Math.max(ans1, ans2);
    }

    public int calculate(int[] slices) {
        int N = slices.length, n = (N + 1) / 3;
        int[][] dp = new int[N][n + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;//不选
        dp[0][1] = slices[0];//选第一个
        dp[1][0] = 0;//前两个都不选
        dp[1][1] = Math.max(slices[0], slices[1]);//前两个选一个较大值
        for (int i = 2; i < N; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i]);
            }
        }
        return dp[N - 1][n];
    }


    public int maxSizeSlices2(int[] slices) {
        //这不就是首尾连接版本的射击气球获得硬币那道题吗？直接上区间dp
        //dp[i][j]表示i~j的范围内可以获得披萨的最大值
        //写了半天不行，滚去看题解。思路转换是关键：给一个长度为 3n 的环状序列，你可以在其中选择 n 个数，并且任意两个数不能相邻，求这 n 个数的最大值
        //这不就是打家劫舍那道题么。。。
        int n=slices.length,m=n/3;
        return Math.max(h(slices,1,n-1),h(slices,2,n));
    }
    private int h(int[] slices,int lb,int ub){
        int n=slices.length,m=n/3;
        int[][] dp=new int[n+1][m+1];
        //dp[i][j]表示前i个元素中选出j个不相邻元素的最大值
        for(int i=lb;i<=ub;i++){
            for(int j=1;j<=Math.min(i,m);j++){
                dp[i][j]=Math.max(dp[i-1][j],(i>=2?dp[i-2][j-1]:0)+slices[i-1]);
            }
        }
        return dp[ub][m];
    }

}
