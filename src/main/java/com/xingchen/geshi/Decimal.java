package com.xingchen.geshi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.geshi
 * @date 2022/8/30 20:31
 */
public class Decimal {
    public static void main(String[] args) {
        // 实例化DecimalFormat类的对象，并指定格式
        DecimalFormat df1 = new DecimalFormat("0.0");
        DecimalFormat df2 = new DecimalFormat("#.#");
        DecimalFormat df3 = new DecimalFormat("000.000");
        DecimalFormat df4 = new DecimalFormat("###.###");
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入一个float类型的数字：");
        float f = scan.nextFloat();
        // 对输入的数字应用格式，并输出结果
        System.out.println("0.0 格式：" + df1.format(f));
        System.out.println("#.# 格式：" + df2.format(f));
        System.out.println("000.000 格式：" + df3.format(f));
        System.out.println("###.### 格式：" + df4.format(f));
    }
}
