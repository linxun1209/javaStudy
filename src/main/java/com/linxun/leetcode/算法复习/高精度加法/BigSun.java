package com.linxun.leetcode.算法复习.高精度加法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 高精度加法
 * @date 2024/7/19 15:28
 */
public class BigSun {
    /**
     * 大数据加法
     */
    private static List<Integer> add(List<Integer> A, List<Integer> B) {
        // 默认A > B，如果不满足则对调
        if (A.size() < B.size()) {
            return add(B, A);
        }
        int t = 0;
        List<Integer> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            t += A.get(i);
            // 如果在B的范围内，则加B
            if (i < B.size()) {
                t += B.get(i);
            }
            // C记录余数
            C.add(t % 10);
            t /= 10;
        }
        // 进位
        if (t != 0) {
            C.add(t);
        }
        // 去掉开头的零
        while (C.size() > 1 && C.get(C.size() - 1) == 0) {
            C.remove(C.size() - 1);
        }
        return C;
    }
}

