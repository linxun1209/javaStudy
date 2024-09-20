package com.面试中的算法.小米秋招笔试;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/19 16:56
 */
public class Main2 {
    public static void main(String[] args) {

        //输入描述的初始化
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[n];
            boolean hasZero = false;
            boolean haseOne = false;
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                if (b[i] == 0) {
                    hasZero = true;
                }
                if (b[i] == 1) {
                    haseOne = true;
                }
            }
            boolean isSorted = true;
            for (int i = 1; i < n; i++) {
                if (a[i] < a[i - 1]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted || (haseOne && hasZero)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

}

