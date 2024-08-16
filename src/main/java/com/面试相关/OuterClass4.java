package com.面试相关;


/**
 * 匿名内部类
 */
public class OuterClass4 {
    interface Greeting {
        void greet();
    }

    public void sayHello() {
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello, World!");
            }
        };
        greeting.greet();
    }
}
