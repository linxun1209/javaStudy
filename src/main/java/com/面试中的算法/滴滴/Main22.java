package com.面试中的算法.滴滴;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/7 17:52
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//长度
        int k = in.nextInt();//类型
        int[][] arr = new int[k][k];//矩阵
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        String str = in.next();//小明的字符串
        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i+=2) {//偶数
            for (int j = 0; j < n - i; j++) {
                int m = j + i - 1;
                dp[j][m] = 0;
                for (int l = j; l < m; l++) {
                    int l2 = l + 1;
                    if (l2 <= m) {
                        dp[j][m] = Math.min(dp[j][m], dp[j][l] + dp[l2][m] + arr[str.charAt(l) - 'a']
                                [str.charAt(l2) - 'a']);
                    }
                }
                for (int l = 0; l < m; l++) {
                    int l2 = l + 1;
                    if (l2 < m) {
                        dp[j][m] = Math.min(dp[j][m], dp[j][l] + dp[l2][m] + arr[str.charAt(l) - 'a']
                                [str.charAt(l2) - 'a']);
                    }
                }
            }
        }
        System.out.println(dp[0][n - k]);
    }
}

