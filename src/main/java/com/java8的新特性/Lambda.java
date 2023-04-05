package com.java8的新特性;




import java.util.Comparator;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/9/18 16:20
 */


/**
 *

3.1 Lamdba表达式基本语法
        1.举例： (o1,o2) -> Integer.compare(o1,o2);
        2.格式：

        -> ：lambda 操作符 或 箭头操作符
        -> 左边：lambda 形参列表 （其实就是接口中的抽象方法的形参列表）
        -> 右边：lambda 体（其实就是重写的抽象方法的方法体）
 */


public class Lambda {
    //语法格式一：无参，无返回值

    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("*******************");
        Runnable r2 = ()-> System.out.println("我爱北京天安门");
        r2.run();
    }


    public void test2(){
        //未使用Lambda表达式的写法
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 32);
        System.out.println(compare1);//-1
        System.out.println("===================");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(54, 21);
        System.out.println(compare2);//1
        System.out.println("===================");

        //方法引用
        Comparator<Integer> cpm3 = Integer::compareTo;
        int compare3 = cpm3.compare(12, 12);
        System.out.println(compare3);//0
    }




}
