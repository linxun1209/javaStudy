package com.面试相关;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        Map<String, String> weakMap = new WeakHashMap<>();
        String key1 = new String("key1");
        String key2 = new String("key2");

        // 放入键值对
        weakMap.put(key1, "value1");
        weakMap.put(key2, "value2");

        System.out.println("Before GC: " + weakMap);

        // 清除强引用
        key1 = null;

        // 触发垃圾回收
        System.gc();

        // 等待垃圾回收完成
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印 WeakHashMap 的内容
        System.out.println("After GC: " + weakMap);
    }
}

