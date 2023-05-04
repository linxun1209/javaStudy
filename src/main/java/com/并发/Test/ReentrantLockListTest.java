package com.并发.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/29 15:03
 */
public class ReentrantLockListTest {
    //线程不安全的list
    private ArrayList<String> arrayList=new ArrayList<>();
    //独占锁
    private volatile ReentrantLock lock=new ReentrantLock();

    //添加元素
    public void add(String e){
        lock.lock();
        try {
            arrayList.add(e);

        }finally {
            lock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        lock.lock();
        try{
            arrayList.remove(e);

        }finally {
            lock.unlock();
        }
    }

    //获取数据
    public String get(int index){
        lock.lock();
        try {
            return arrayList.get(index);
        }finally {
            lock.unlock();
        }
    }

}
