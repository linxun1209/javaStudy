package com.面试相关;


/**
 * 局部内部类
 */
public class OuterClass3 {
    void outerMethod() {
        final String localVar = "Local Variable";

        class LocalInnerClass {
            void display() {
                System.out.println("Local Variable: " + localVar);
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();
    }
}
