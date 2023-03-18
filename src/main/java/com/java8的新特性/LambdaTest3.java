package com.java8的新特性;


import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/11/2 19:40
 */
public class LambdaTest3 {
    //    消费型接口 Consumer<T>     void accept(T t)
    @Test
    public void test1() {
        //未使用Lambda表达式
        Learn("java", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("学习什么？ " + s);
            }
        });
        System.out.println("====================");
        //使用Lambda表达
        Learn("html", s -> System.out.println("学习什么？ " + s));

    }

    private void Learn(String s, Consumer<String> stringConsumer) {
        stringConsumer.accept(s);
    }

    //    供给型接口 Supplier<T>     T get()
    @Test
    public void test2() {
        //未使用Lambdabiaodas
        Supplier<String> sp = new Supplier<String>() {
            @Override
            public String get() {
                return new String("我能提供东西");
            }
        };
        System.out.println(sp.get());
        System.out.println("====================");
        //使用Lambda表达
        Supplier<String> sp1 = () -> new String("我能通过lambda提供东西");
        System.out.println(sp1.get());
    }

    //函数型接口 Function<T,R>   R apply(T t)
    @Test
    public void test3() {
        //使用Lambda表达式
        Integer id = null;
        Employee employee = new Employee(id);

        Function<Employee, String> func1 =e->e.getName();
        System.out.println(func1.apply(employee));
        System.out.println("====================");

        //使用方法引用
        Function<Employee,String>func2 = Employee::getName;
        System.out.println(func2.apply(employee));

    }

    //断定型接口 Predicate<T>    boolean test(T t)
    @Test
    public void test4() {
        //使用匿名内部类
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(func.apply(10.5));
        System.out.println("====================");

        //使用Lambda表达式
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));
        System.out.println("====================");

        //使用方法引用
        Function<Double,Long>func2 = Math::round;
        System.out.println(func2.apply(12.6));

    }
}