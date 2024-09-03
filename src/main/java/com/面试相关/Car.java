package com.面试相关;

public class Car {
    private String model; // 私有属性，外部无法直接访问
    private int year;

    // 构造方法
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // getter 方法
    public String getModel() {
        return model;
    }

    // setter 方法
    public void setModel(String model) {
        this.model = model;
    }

    // 行为方法
    public void startEngine() {
        System.out.println("Engine started for " + model);
    }
}

