package com.面试相关;


/**
 * 静态内部类
 */
public class OuterClass2 {
    private static String staticOuterField = "Static Outer Field";

    static class StaticInnerClass {
        void display() {
            System.out.println("Static Outer Field: " + staticOuterField);
        }
    }

    public static void createStaticInner() {
        StaticInnerClass staticInner = new StaticInnerClass();
        staticInner.display();
    }
}
