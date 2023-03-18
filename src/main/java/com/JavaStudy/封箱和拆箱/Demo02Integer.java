package com.JavaStudy.封箱和拆箱;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.封箱和拆箱
 * @date 2022/9/17 15:03
 */


import java.util.ArrayList;


/*
 * 自动拆箱与自动装箱：基本类型的数据和包装类之间可以互相转换
 * jdk1.5之后出现的新特性
 * */
public class Demo02Integer {
    public static void main(String[] args) {
        /*
         * 自动装箱：直接把int类型的整数赋值给包装类
         * Integer in = 1; 就相当于Integer in = new Integer(1);
         * */
        Integer in = 1;

        /*
         * 自动拆箱：in 是包装类，无法直接参与运算，可以自动转换为基本数据雷兴国，在进行计算
         * in+2；相当于in.intValue()+2
         * in = in.inValue()+2 = 3;又是一个自动装箱
         * */
        in = in+2;

        ArrayList<Integer> list = new ArrayList<>();

        /*
         * ArrayList集合无法直接存储整数，可以存储Integer包装类
         * */
        list.add(1);//-->隐含了一个自动装箱，list.add(new Integer(1));
        Integer a = list.get(0);//-->隐含了一个自动拆箱，list.get(o).intValue();
    }
}

