package com.面试中的算法.美团8_17第一次笔试;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author xing'chen
 * @version 1.0
 * @description:
小美有一个长度为 n 的数组，每次操作可以选择两个下标之和 j，将 a:减去1，将 aj加上 1。小美想知道最少需要多少次操作，可以使数组极差最小、
数组的极差为数组中最大值和最小的差
1输入描述
第一行输入一个整数 n(2 < n < 105)代表数组的长度.
第二行输入 几 个整数 a1,a2,·..,an(1 ≤ a¡≤ 10°)代表数组的元素
1输出描述
在一行上输出一个整数，表示最少需要多少次操作,
 * @date 2024/8/17 22:10
 *
 *
 */
public class Main2 {


    /**
     * 使得极差最小，只有两种情况
     * 1.几个数可以除尽，那么只需要计算小于平均值那一部分和平均数的差值加到一起就得到了（大于平均数的一样，因为每次取出两个数进行分别加减）
     * 2，几个数不可以除尽，则可以令其中几个为平均数（向下取整），另外几个为平均数+1
     * 由此可以得到最小极差只能有0或者1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        long sum = 0;
        for (int i = 1; i <= n; ++i) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        long ans = 0;
        long ave = sum / n;
        // 如果平均值刚好是整数，那么直接计算
        if (ave * n == sum) {
            for (int i = 1; i <= n; ++i) {
                //大于的跟小于的肯定是相等的。取其中的一部分就好啦
                if (a[i] < ave) {
                    ans += ave - a[i];
                }
            }
        } else {
            int cnt = (int) (sum - ave * n);
            cnt = n - cnt;
            Arrays.sort(a, 1, n + 1);
            for (int i = 1; i <= n; ++i) {
                if (i <= cnt && a[i] < ave) {
                    ans += ave - a[i];
                } else if (i > cnt && a[i] < ave + 1) {
                    ans += ave + 1 - a[i];
                }
            }
        }
        System.out.println(ans);
    }
}