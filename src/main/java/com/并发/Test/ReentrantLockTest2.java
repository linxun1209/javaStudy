package com.并发.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/5/5 22:47
 */
public class ReentrantLockTest2 {
    //线程不安全的list
    private ArrayList<String> arrayList=new ArrayList<String>();
    //独占锁
    private final ReentrantReadWriteLock lock =new ReentrantReadWriteLock();
    private final Lock readLock=lock.readLock();
    private final Lock writeLock=lock.writeLock();

    //添加元素
    public void add(String e){
        writeLock.lock();

        try{
            arrayList.add(e);
        }finally {
            writeLock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        writeLock.lock();
        try {
            arrayList.remove(e);
        }finally {
            writeLock.unlock();
        }
    }

    //获取数据
    public String get(int index){
        readLock.lock();
        try {
            return arrayList.get(index);
        }finally {
            readLock.unlock();
        }
    }

}
