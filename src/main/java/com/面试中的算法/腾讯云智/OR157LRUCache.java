package com.面试中的算法.腾讯云智;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 设计一个数据结构，实现LRU Cache的功能(Least Recently Used – 最近最少使用缓存)。它支持如下2个操作： get 和 put。
 *
 * int get(int key) – 如果key已存在，则返回key对应的值value（始终大于0）；如果key不存在，则返回-1。
 * void put(int key, int value) – 如果key不存在，将value插入；如果key已存在，则使用value替换原先已经存在的值。如果容量达到了限制，LRU Cache需要在插入新元素之前，将最近最少使用的元素删除。
 *
 * 请特别注意“使用”的定义：新插入或获取key视为被使用一次；而将已经存在的值替换更新，不算被使用。
 * @date 2024/6/13 8:51
 */
public class OR157LRUCache {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.valueOf(scanner.nextLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] sp=s.split(" ");
            if(sp[0].equals("p")){
                Integer key=Integer.valueOf(sp[1]);
                Integer value=Integer.valueOf(sp[2]);
                map.put(key,value);
                if(map.size()>n){
                    Iterator<Integer> it=map.keySet().iterator();
                    Integer temp=it.next();
                    map.remove(temp);
                }
            }else  if(sp[0].equals("g")){
                Integer key=Integer.valueOf(sp[1]);
                int val=-1;
                if(map.containsKey(key)){
                    val=map.get(key);
                    map.remove(key);
                    map.put(key,val);
                }
                System.out.println(val);
            }

        }
    }
}


