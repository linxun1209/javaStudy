package com.集合源码.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/4/9 21:59
 */
public class ArrayListOrArray {

    public static void main(String[] args) {
        // 初始化一个 String 类型的数组
        String[] stringArr = new String[]{"hello", "world", "!"};
        // 修改数组元素的值
        stringArr[0] = "goodbye";
        System.out.println(Arrays.toString(stringArr));// [goodbye, world, !]
        // 删除数组中的元素，需要手动移动后面的元素
        for (int i = 0; i < stringArr.length - 1; i++) {
            stringArr[i] = stringArr[i + 1];
        }
        stringArr[stringArr.length - 1] = null;
        System.out.println(Arrays.toString(stringArr));// [world, !, null]




        // 初始化一个 String 类型的 ArrayList
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("hello", "world", "!"));
        // 添加元素到 ArrayList 中
        stringList.add("goodbye");
        System.out.println(stringList);// [hello, world, !, goodbye]
        // 修改 ArrayList 中的元素
        stringList.set(0, "hi");
        System.out.println(stringList);// [hi, world, !, goodbye]
        // 删除 ArrayList 中的元素
        stringList.remove(0);
        System.out.println(stringList); // [world, !, goodbye]




        //空指针异常
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add(null);
        listOfStrings.add("java");
        System.out.println(listOfStrings);


        //omparator 定制排序
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);
    }
}

