package com.面试中的算法.腾讯音乐;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/21 21:05
 */
public class kawaiiStrings {
    public int kawaiiStrings (int n) {
        // write code here
        if(n<=3){
            return 0;
        }
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=0;
        dp[2]=0;
        dp[3]=0;
        dp[4]=1;
        for (int i = 5; i < n; i++) {
            for (int j=4;j<n;j++){

            }
        }
        return 0;
    }

    public int kawaiiStrings2 (int n) {
        long mod=1000000007;
        long[] f=new long[n+1];
        long[] g=new long[n+1];
        long[] h=new long[n+1];
        for (int i = 2; i <=n ; i++) {

        }
        return 0;
    }

    public long fastexp(long base, long n, long mod) {
        long answer=1;
        while (n>0){
            if(n%2==1){
                answer=(answer*base)%mod;
            }
            base=(base*base)%mod;
            n/=2;
        }
        return (int)answer;
    }

}

