package com.linxun.leetcode.hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/25 19:49
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> cache;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry entry){
                return cache.size()>capacity;
            }
        };

    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        cache.put(key,value);
    }

}
