package com.面试中的算法.去哪儿.去哪儿9_6秋招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 21:23
 */
public class Main33 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String t = scanner.next();
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int[] cnt = new int[10];
            for (int len = 1; len <= i; len++) {
                int id = t.charAt(i - len) - '0';
                cnt[id]++;
                int g = 0;
                for (int j = 0; j < 10; j++) {
                    g = gcd(g, cnt[j]);
                }
                if (g > 1 && dp[i - len] != -1) {
                    dp[i] =Math.max(dp[i], 1 + dp[i - len]);
                }
            }
        }

        System.out.println(dp[n]);
    }
}