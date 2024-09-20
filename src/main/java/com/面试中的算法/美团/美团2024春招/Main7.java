package com.面试中的算法.美团.美团2024春招;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 14:39
 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cnt2 = new int[n];
        int[] cnt5 = new int[n];
        long sum2 = 0, sum5 = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int[] cnt = cnt(a);
            sum2 += cnt2[i] = cnt[0];
            sum5 += cnt5[i] = cnt[1];
        }
        if (sum2 < k || sum5 < k) {
            System.out.println(0);
            return;
        }
        int l = 0;
        long ans = 0;
        for (int r = 0; r < n; r++) {
            sum2 -= cnt2[r];
            sum5 -= cnt5[r];
            while (sum2 < k || sum5 < k) {
                ans += r - l;
                sum2 += cnt2[l];
                sum5 += cnt5[l];
                l++;
            }
        }
        ans += (long) (n - l) * (1 + n - l) / 2;
        System.out.println(ans);
    }

    static int[] cnt(int num) {
        int res2 = 0;
        while (num % 2 == 0) {
            res2++;
            num /= 2;
        }
        int res5 = 0;
        while (num % 5 == 0) {
            res5++;
            num /= 5;
        }
        return new int[]{res2, res5};
    }
}

