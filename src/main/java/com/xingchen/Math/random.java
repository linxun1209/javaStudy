package com.xingchen.Math;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.Math
 * @date 2022/8/30 20:25
 */
public class random {
    public static void main(String[] args) {
        int min = 2; // 定义随机数的最小值
        int max = 102; // 定义随机数的最大值
        // 产生一个2~100的数
        int s = (int) min + (int) (Math.random() * (max - min));
        if (s % 2 == 0) {
            // 如果是偶数就输出
            System.out.println("随机数是：" + s);
        } else {
            // 如果是奇数就加1后输出
            System.out.println("随机数是：" + (s + 1));
        }
    }
}
