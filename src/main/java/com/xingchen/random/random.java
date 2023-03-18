package com.xingchen.random;

import java.util.Random;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.random
 * @date 2022/8/30 20:22
 */
public class random {
    public static void main(String[] args) {
        Random r = new Random();
        double d1 = r.nextDouble(); // 生成[0,1.0]区间的小数
        double d2 = r.nextDouble() * 7; // 生成[0,7.0]区间的小数
        int i1 = r.nextInt(10); // 生成[0,10]区间的整数
        int i2 = r.nextInt(18) - 3; // 生成[-3,15)区间的整数
        long l1 = r.nextLong(); // 生成一个随机长整型值
        boolean b1 = r.nextBoolean(); // 生成一个随机布尔型值
        float f1 = r.nextFloat(); // 生成一个随机浮点型值
        System.out.println("生成的[0,1.0]区间的小数是：" + d1);
        System.out.println("生成的[0,7.0]区间的小数是：" + d2);
        System.out.println("生成的[0,10]区间的整数是：" + i1);
        System.out.println("生成的[-3,15]区间的整数是：" + i2);
        System.out.println("生成一个随机长整型值：" + l1);
        System.out.println("生成一个随机布尔型值：" + b1);
        System.out.println("生成一个随机浮点型值：" + f1);
        System.out.print("下期七星彩开奖号码预测：");
        for (int i = 1; i < 8; i++) {
            int num = r.nextInt(9); // 生成[0,9]区间的整数
            System.out.print(num);
        }
    }
}
