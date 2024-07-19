package com.linxun.leetcode.算法复习.浮点数二分算法模板;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 浮点数二分算法模板
 * @date 2024/7/19 15:25
 */
public class floatBinarySearch {
    // 检查x是否满足某种性质
    private static boolean check(double x) {
        return true;
    }

    // eps 表示精度，取决于题目对精度的要求，默认负六次方
    private static double EPS = 1e-6;

    private static double floatBinarySearch(double left, double right) {
        while (right - left > EPS) {
            double mid = (left + right) / 2;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

}

