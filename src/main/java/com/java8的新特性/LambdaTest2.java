package com.java8的新特性;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/11/2 19:12
 *
 *
 *
 *
 * Lambda 表达式的本质：作为函数式接口的实例
 * 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 * 因此以前用匿名实现类表示的现在都可以用 Lambda 表达式来写。

 */
public class LambdaTest2 {
    //语法格式一：无参，无返回值
    @Test
    public void test1() {
        //未使用Lambda表达式
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lamdba");
            }
        };
        r1.run();
        System.out.println("====================");
        //使用Lambda表达式
        Runnable r2 = () -> {
            System.out.println("Hi Lamdba");
        };
        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值。
    @Test
    public void test2() {
        //未使用Lambda表达式
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("你好啊Lambda！");
        System.out.println("====================");
        //使用Lambda表达式
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("我是Lambda");

    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3() {
        //未使用Lambda表达式
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("你好啊Lambda！");
        System.out.println("====================");
        //使用Lambda表达式
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("我是Lambda");
    }

    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();//类型推断，用左边推断右边
        int[] arr = {1,2,3,4};//类型推断，用左边推断右边
    }

    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        //未使用Lambda表达式
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("你好啊Lambda！");
        System.out.println("====================");
        //使用Lambda表达式
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("我是Lambda");
    }

    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        //未使用Lambda表达式
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(23, 45));
        System.out.println("====================");
        //使用Lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(23, 12));
    }

    //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test6() {
        //未使用Lambda表达式
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(23, 45));
        System.out.println("====================");
        //使用Lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(23, 12));
    }
    @Test
    public void test7(){
        //未使用Lambda表达式
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("hi!");
        System.out.println("====================");
        //使用Lambda表达式
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("hello");
    }

}
