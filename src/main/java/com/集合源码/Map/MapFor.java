package com.集合源码.Map;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.集合源码.Map
 * @date 2022/10/21 16:19
 */
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
//第一组: 先取出 所有的 Key , 通过 Key 取出对应的 Value
        Set keyset = map.keySet();//(1) 增强 for
        System.out.println("-----第一种方式-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }
//(2) 迭代器
        System.out.println("----第二种方式--------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
//第二组: 把所有的 values 取出
        Collection values = map.values();
//这里可以使用所有的 Collections 使用的遍历方法
//(1) 增强 for
        System.out.println("---取出所有的 value 增强 for----");
        for (Object value : values) {
            System.out.println(value);
        }
//(2) 迭代器
        System.out.println("---取出所有的 value 迭代器----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
        }
//第三组: 通过 EntrySet 来获取 k-v
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
//(1) 增强 for
        System.out.println("----使用 EntrySet 的 for 增强(第 3 种)----");
        for (Object entry : entrySet) {
//将 entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
//(2) 迭代器
        System.out.println("----使用 EntrySet 的 迭代器(第 4 种)----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry = iterator3.next();
//System.out.println(next.getClass());//HashMap$Node -实现-> Map.Entry (getKey,getValue)
//向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}
