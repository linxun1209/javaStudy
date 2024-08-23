package com.面试中的算法.腾讯音乐;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/21 20:53
 */
public class cntOfTrees {

    long divide = 1000000007;
    public int cntOfTrees (int n) {
        // write code here
        if(n%2==0){
            return 0;
        }
        long[] dp=new long[3001];
        dp[1]=1;
        dp[3]=1;
        for (int i=5;i<=n;i+=2){
            int nodeNum=i-1;
            for (int j=1;j<nodeNum;j+=2){
                dp[i]+=(dp[j]*dp[nodeNum-j])%divide;
                dp[i]%=divide;
            }
        }
        return (int)dp[n];
    }
}

