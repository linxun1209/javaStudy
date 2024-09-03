package com.面试相关;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        // 创建一个 List 集合
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // 获取集合的迭代器
        Iterator<String> iterator = list.iterator();

        // 使用迭代器遍历集合
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // 移除集合中的元素
        iterator = list.iterator();  // 重新获取迭代器
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("Banana")) {
                iterator.remove();
            }
        }

        // 再次遍历集合，确认元素已被移除
        System.out.println("After removal:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
