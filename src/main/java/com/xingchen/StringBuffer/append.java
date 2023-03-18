package com.xingchen.StringBuffer;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.StringBuffer
 * @date 2022/8/30 19:56
 */
import java.util.Scanner;
public class append {
    public static void main(String[] args) {
        StringBuffer sys = new StringBuffer("校内课程管理");
        System.out.println("欢迎进入《" + sys + "》系统");
        // 声明课程名称字符串
        StringBuffer courseName = new StringBuffer();
        System.out.println("请录入本期的五门必修课名称：");
        Scanner input = new Scanner(System.in);
        // 循环接收控制台输入的字符串
        String name = "";
        for (int i = 0; i < 5; i++) {
            name = input.next();
            courseName.append(name + "\t");
            if (i == 4) {
                System.out.println("录入完毕!");
            }
        }
        System.out.println("本学期的必修课程有：\n" + courseName);
    }
}
