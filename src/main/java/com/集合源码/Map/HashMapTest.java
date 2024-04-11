package com.集合源码.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {


//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap();
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, String> entry = iterator.next();
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }



        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 遍历
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }



//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap();
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }



//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap();
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        for (Integer key : map.keySet()) {
//            System.out.println(key);
//            System.out.println(map.get(key));
//        }



//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap();
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        map.forEach((key, value) -> {
//            System.out.println(key);
//            System.out.println(value);
//        });


//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap();
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        map.entrySet().stream().forEach((entry) -> {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        });


//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap();
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        map.entrySet().parallelStream().forEach((entry) -> {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        });
    }
}