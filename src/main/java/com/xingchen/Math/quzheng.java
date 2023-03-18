package com.xingchen.Math;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.Math
 * @date 2022/8/30 20:19
 */
public class quzheng {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        double num = input.nextDouble();
        System.out.println("大于或等于 "+ num +" 的最小整数：" + Math.ceil(num));
        System.out.println("小于或等于 "+ num +" 的最大整数：" + Math.floor(num));
        System.out.println("将 "+ num +" 加上 0.5 之后最接近的整数：" + Math.round(num));
        System.out.println("最接近 "+num+" 的整数：" + Math.rint(num));
    }
}
