package com.面试相关;

public class EncapsulationExample {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2021);
        myCar.startEngine(); // 使用公共方法

        // 使用 getter 和 setter 方法访问和更新属性
        System.out.println("Car model: " + myCar.getModel());
        myCar.setModel("Honda");
    }
}
