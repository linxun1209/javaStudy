package com.集合源码.LinkedList;

import java.util.LinkedList;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/4/14 21:44
 */
public class LinkedListTest {
    public static void main(String[] args) {
        // 创建 LinkedList 对象
        LinkedList<String> list = new LinkedList<>();

// 添加元素到链表末尾
        list.add("apple");
        list.add("banana");
        list.add("pear");
        System.out.println("链表内容：" + list);

// 在指定位置插入元素
        list.add(1, "orange");
        System.out.println("链表内容：" + list);

// 获取指定位置的元素
        String fruit = list.get(2);
        System.out.println("索引为 2 的元素：" + fruit);

// 修改指定位置的元素
        list.set(3, "grape");
        System.out.println("链表内容：" + list);

// 删除指定位置的元素
        list.remove(0);
        System.out.println("链表内容：" + list);

// 删除第一个出现的指定元素
        list.remove("banana");
        System.out.println("链表内容：" + list);

// 获取链表的长度
        int size = list.size();
        System.out.println("链表长度：" + size);

// 清空链表
        list.clear();
        System.out.println("清空后的链表：" + list);

    }
}

