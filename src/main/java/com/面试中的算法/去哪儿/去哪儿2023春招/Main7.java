package com.面试中的算法.去哪儿.去哪儿2023春招;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 19:24
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long target = in.nextLong();
        long[] num = new long[n];
        long[] nul = new long[n];
        for (int i = 0; i < n; i++) {
            nul[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            num[i] = in.nextLong();
        }
        int index = n - 1;
        int day = n - 1;
        boolean flag = false;
        while (index >= 0) {
            long[] tempNum = Arrays.copyOf(num, index);
            long[] tempNul = Arrays.copyOf(nul, index);
            Arrays.sort(tempNum);
            Arrays.sort(tempNul);
            long sum = 0;
            for (int i = index - 1; i >= 0; i--) {
                sum += tempNum[i] * tempNul[i];
                if (sum >= target) {
                    day = Math.max(day, index);
                    flag = true;
                    break;
                }
            }
            index--;
        }
        if (flag) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
}

