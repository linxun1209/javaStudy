package com.面试中的算法.美团.美团8_10第一次笔试;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取密码个数
        String correctPassword = scanner.next(); // 读取正确的密码

        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) {
            passwords[i] = scanner.next(); // 读取所有可能的密码
        }

        int minAttempts = 1; // 最少尝试次数，假设第一次就猜中
        int maxAttempts = n - 1; // 最多尝试次数，假设最后一个才是正确的

        // 检查最少尝试次数是否为1
        for (int i = 0; i < n; i++) {
            if (passwords[i].equals(correctPassword)) {
                minAttempts = i + 1; // 如果找到了正确的密码，更新最少尝试次数
                break;
            }
        }

        // 检查最多尝试次数是否为n-1
        for (int i = 0; i < n - 1; i++) {
            if (passwords[i].equals(correctPassword)) {
                maxAttempts = i + 1; // 如果在最后一个之前找到了正确的密码，更新最多尝试次数
                break;
            }
        }

        System.out.println(minAttempts + " " + maxAttempts); // 输出最少和最多尝试次数
    }
}