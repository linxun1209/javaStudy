package com.linxun.leetcode.面试经典150题.位运算;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 191. 位1的个数
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位的个数（也被称为汉明重量）。
 * @date 2024/8/15 22:09
 */
public class hammingWeight {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }


    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}

