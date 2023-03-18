package com.JavaStudy.封箱和拆箱;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.封箱和拆箱
 * @date 2022/9/17 15:02


/*
 * 装箱：把基本类型的数据，包装到包装类中（基本类型的数据->包装类）
 *   构造方法：
 *       Integer(int value) 构造一个新分配的Integer对象，他表示指定的int值。
 *       Integer(String s) 构造一个新分配的Integer对象，他表示String参数所指示的int值。
 *           传递的字符串必须是基本类型的字符串，否则会出现抛出异常     例：“100”正确，“a"抛出异常
 *
 *   静态方法：
 *       static Integer valueOf(int i）返回一个表示指定的int值得Integer实例
 *       static Integer valueOf(String s）返回保存指定的String的值得Integer对象
 * 拆箱：在包装类中取出基本数据类型的数据(包装类->基本数据类型）
 *   成员方法：
 *       int intValue() 以int类型返回该 Integer的值
 * */
public class Demo01Integer {
    public static void main(String[] args) {
        /**
         *
         *
        装箱：把基本类型的数据，包装到包装类中（基本类型的数据->包装类）
        构造方法
         */
        Integer in1 = new Integer(1);
        System.out.println(in1);//重写了toString()方法

        Integer in2 = new Integer("2");
        System.out.println(in2);

        //静态方法：
        Integer in3 = Integer.valueOf(1);
        System.out.println(in3);

//        Integer in4 = Integer.valueOf("a");//NumberFormatException数字格式化错误
        Integer in4 = Integer.valueOf("2");
        System.out.println(in4);


        //拆箱：在包装类中取出基本数据类型的数据(包装类->基本数据类型）
        int i = in1.intValue();
        System.out.println(i);
    }
}

