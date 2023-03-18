package com.牛客;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.牛客
 * @date 2022/10/17 19:35
 */
class A {
    public int func1(int a, int b) {
        return a - b;
    }
}
class B extends A {
    @Override
    public int func1(int a, int b) {
        return a + b;
    }
}
public class ChildClass {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println("Result=" + a.func1(100, 50));
        System.out.println("Result=" + b.func1(100, 50));
    }
}
