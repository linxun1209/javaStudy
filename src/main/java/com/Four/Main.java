package com.Four;

public class Main {
    /*
    d)创建Main类，在main方法中实现下方操作
1)创建两个Automobile对象automobile1和automobile2，分别输出automobile1和automobile2，并调用其equals方法判断两个对象是否相等。
2)先输出automobile1的速度（speed)变量的值，然后调用accelerate()方法并打印速度（speed)变量的值，
接着调用slowDown()方法并打印速度（speed)变量的值。
     */
    public static void main(String[] args) {
        Automobile automobile1=new Automobile("123X",23,55);
        Automobile automobile2=new Automobile("125X",26,65);
        System.out.println(automobile1.equals(automobile2));
        System.out.println(automobile1.getSpeed());
        automobile1.accelerate();
        System.out.println(automobile1);
        automobile1.slowDown();
        System.out.println(automobile1);
    }
}
