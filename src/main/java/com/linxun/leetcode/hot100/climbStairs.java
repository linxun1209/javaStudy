package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/9 18:56
 */
public class climbStairs {
    public int climbStairs4(int n) {
        int[] dp=new int[n+1];
        int m=2;
        dp[0]=1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(i>=j){
                    dp[i]+=dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public int climbStairs3(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs2(int n) {
        if(n<=2) return n;
        int a=1,b=2,sum=0;
        for(int i=3;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return b;



    }
}
