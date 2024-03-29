package com.linxun.leetcode.面试经典150题.链表;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 146. LRU 缓存
 * @date 2024/3/29 9:23
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }




}

