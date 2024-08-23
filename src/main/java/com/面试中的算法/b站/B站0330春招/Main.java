package com.面试中的算法.b站.B站0330春招;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/21 18:27
 */


public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int N = scanner.nextInt();
        int [][] arr = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int result = helper(arr, 0, 0, N - 1, N - 1);
        System.out.println(result);
    }

    public static int helper(int[][] arr, int left, int top, int right, int bottom) {
        int n = right - left + 1;
        if (n == 1) {
            return arr[left][top];
        }
        List<Integer> a = new ArrayList<>();
        a.add(helper(arr, left, top, left + n / 2 - 1, top + n / 2 - 1));
        a.add(helper(arr, left, n / 2 + top, left + n / 2 - 1, bottom));
        a.add(helper(arr, n / 2 + left, top, right, top + n / 2 - 1));
        a.add(helper(arr, n / 2 + left, n / 2 + top, right, bottom));
        Collections.sort(a, Collections.reverseOrder());
        return a.get(1);
    }
}
