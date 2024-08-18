package com.面试中的算法.深信服;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 20:15
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        int[] dp=new int[n];
        dp[0]=arr[0];
        int maxSum=dp[0];
        for (int i = 1; i < n; i++) {
            if(i>=k){
                dp[i]=Math.max(dp[i-1],arr[i]+dp[i-k]);
            }else {
                dp[i]=Math.max(dp[i-1],arr[i]);
            }
            maxSum=Math.max(maxSum,dp[i]);
        }
        System.out.println(maxSum);
        in.close();
    }
}

