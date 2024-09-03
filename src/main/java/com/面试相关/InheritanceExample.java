package com.面试相关;

class Animal {
    void breathe() {
        System.out.println("Breathing");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
    
    @Override
    void breathe() {
        System.out.println("Breathing through lungs");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // 多态性
        myAnimal.breathe(); // 调用 Dog 类的 breathe 方法
        ((Dog) myAnimal).bark(); // 向下转型并调用 Dog 类的 bark 方法
    }
}
