package com.linxun.leetcode.hot100;

import java.util.Arrays;

public class numSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);

            }
        }
        return dp[n];

    }

    public int numSquares2(int n) {
        while(n % 4 == 0) n /= 4;  //判4
        if(n % 8 == 7) return 4;

        for(int i = 0; i * i <= n; ++i) {  //判1
            if(n - i * i == 0) return 1;
        }

        for(int i = 0; i * i < n; ++i) {   //判2
            for(int j = 0; j * j < n; ++j) {
                if(n - i * i - j * j == 0) return 2;
            }
        }
        return 3;   //4、1、2，都不是，直接返回3
    }

    public int numSquares3(int n) {
        int max=Integer.MAX_VALUE;
        int[] dp=new int[n+1];

        for (int i=0;i<dp.length;i++){
            dp[i]=max;
        }
        dp[0]=0;
        for(int i=1;i*i<=n;i++){
            for (int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
