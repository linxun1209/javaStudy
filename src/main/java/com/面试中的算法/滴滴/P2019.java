package com.面试中的算法.滴滴;

import java.util.Scanner;

/**
 * 区间dp，每个区间的最值，等于枚举两个小区间之和，即枚举最后一步混合过程
 * 或者这个题里，枚举删除过程一定可以看作是来自两个小区间，或者来自整个大区间，从中间两个开始往外删
 */
public class P2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] cost = new int[k][k];
        // dp[i][j]表示区间可以消耗的最大钱数
        int[][] dp = new int[n][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // 直接用next读入，会忽略空格、回车等
        String s = sc.next();

        // 区间dp
        // 第一维枚举区间长度，长区间的最值，依赖短区间
        for (int l = 2; l <= n; l += 2) {
            // 第二维枚举区间起点，为闭区间起点
            for (int i = 0; i <= n - l; i++) {
                // end为区间终点，且为闭区间
                int end = i + l - 1;
                // 用j来枚举可能的区间分割方式，步长一直为2，要注意j==end作为整个大区间时的状态转移
                for (int j = i + 1; j <= end; j += 2) {
                    if (j == end) {
                        dp[i][end] = Math.max(dp[i][end], dp[i + 1][end - 1] + cost[s.charAt(i) - 'a'][s.charAt(end) - 'a']);
                    } else {
                        dp[i][end] = Math.max(dp[i][end], dp[i][j] + dp[j + 1][end]);
                    }
                }
            }
        }

        System.out.println(dp[0][n - 1]);


    }
}


