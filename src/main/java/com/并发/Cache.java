package com.并发;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/4 11:44
 */
public class Cache {
    static Map<String ,Object> map=new HashMap<String ,Object>();
    static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
    static Lock r=rwl.readLock();
    static Lock w=rwl.writeLock();



    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
    public static final Object put(String key,Object value){
        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }

    }
}
