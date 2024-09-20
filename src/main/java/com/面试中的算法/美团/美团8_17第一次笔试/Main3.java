package com.面试中的算法.美团.美团8_17第一次笔试;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length, multiplier;
        length = scanner.nextInt();
        multiplier = scanner.nextInt();

        long[] elements = new long[length + 1];
        long[] prefixSum = new long[length + 1];
        long[][][] dp = new long[length + 1][length + 1][2];

        for (int i = 1; i <= length; i++) {
            elements[i] = scanner.nextLong();
            prefixSum[i] = prefixSum[i - 1] + elements[i];
        }

        for (int segment = 1; segment <= length; segment++) {
            for (int start = 1; start + segment - 1 <= length; start++) {
                int end = start + segment - 1;
                if (segment == 1) {
                    dp[start][end][0] = dp[start][end][1] = elements[start];
                } else {
                    dp[start][end][0] = Math.min(Math.min(dp[start + 1][end][0], dp[start][end - 1][0]), calculateSum(prefixSum, start, end));
                    dp[start][end][1] = Math.max(Math.max(dp[start + 1][end][1], dp[start][end - 1][1]), calculateSum(prefixSum, start, end));
                }
            }
        }

        long maximumValue = Long.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            for (int j = i; j <= length; j++) {
                long product1 = calculateSum(prefixSum, i, j) * (multiplier - 1);
                long product2 = Math.min(dp[i][j][0] * multiplier * (multiplier - 1), dp[i][j][1] * multiplier * (multiplier - 1));
                if (i != 1) {
                    product2 = Math.min(product2, Math.min(dp[1][i - 1][0] * (multiplier - 1), dp[1][i - 1][1] * (multiplier - 1)));
                }
                if (j != length) {
                    product2 = Math.min(product2, Math.min(dp[j + 1][length][0] * (multiplier - 1), dp[j + 1][length][1] * (multiplier - 1)));
                }
                maximumValue = Math.max(maximumValue, product1 + product2);
            }
        }

        System.out.println(calculateSum(prefixSum, 1, length) + maximumValue);
    }

    private static long calculateSum(long[] prefixSum, int left, int right) {
        return prefixSum[right] - prefixSum[left - 1];
    }


}