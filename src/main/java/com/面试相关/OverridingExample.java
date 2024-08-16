package com.面试相关;


/**
 * 重写
 */
class Parent {
    public void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child display");
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display(); // 输出 "Child display"
    }
}
