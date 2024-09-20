package com.面试中的算法.去哪儿.去哪儿2023春招;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 18:36
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        long m = Integer.parseInt(inputs[1]);
        int[] a = new int[n];
        String[] as = scanner.nextLine().split(" ");
        for (int i = 0; i < n; ++ i) a[i] = Integer.parseInt(as[i]);
        int[] b = new int[n];
        String[] bs = scanner.nextLine().split(" ");
        for (int i = 0; i < n; ++ i) b[i] = Integer.parseInt(bs[i]);

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(mid, a, b, m)) {
                r = mid - 1;
            }
            else l = mid + 1;
        }

        System.out.println(l >= n ? -1 : (l + 1));
    }

    private static boolean check(int k, int[] a, int[] b, long limit) {
        int[] a_copy = Arrays.copyOfRange(a, 0, k + 1);
        Arrays.sort(a_copy);
        int[] b_copy = Arrays.copyOfRange(b, 0, k + 1);
        Arrays.sort(b_copy);

        long t = 0L;
        for (int i = k; i >= 0; -- i) {
            t += (long) a_copy[i] * b_copy[i];
            if (t >= limit) return true;
        }
        return false;
    }
}

