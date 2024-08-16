package com.面试相关;


/**
 * 重载
 *
 */
public class OverloadingExample {
    // 重载方法：参数数量不同
    public void print(int a) {
        System.out.println("Printing int: " + a);
    }

    // 重载方法：参数类型不同
    public void print(String a) {
        System.out.println("Printing String: " + a);
    }

    // 重载方法：参数类型和数量不同
    public void print(int a, int b) {
        System.out.println("Printing two ints: " + a + ", " + b);
    }
}
