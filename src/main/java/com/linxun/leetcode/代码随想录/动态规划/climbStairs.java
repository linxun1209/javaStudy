package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/7 15:47
 */
public class climbStairs {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if(n <= 2) {
            return n;
        }
        int a = 1, b = 2, sum = 0;

        for(int i = 3; i <= n; i++){
            sum = a + b;  // f(i - 1) + f(i - 2)
            a = b;        // 记录f(i - 1)，即下一轮的f(i - 2)
            b = sum;      // 记录f(i)，即下一轮的f(i - 1)
        }
        return b;
    }


    public int climbStairs3(int n) {
        int[] dp=new int[n+1];
        int m=2;
        dp[0]=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(i>=j){
                    dp[i]+=dp[i-j];
                }
            }
        }
        return dp[n];
    }

}
