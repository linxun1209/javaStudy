package com.并发;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/4 21:10
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addTask,removeIndex,count;
    private Lock lock=new ReentrantLock();
    private Condition notFull =lock.newCondition();
    private Condition notEmpty =lock.newCondition();

    public BoundedQueue(int size){
        items=new Object[size];
    }

    public void add(T t) throws InterruptedException{
        lock.lock();
        try {
            while (count==items.length){
                notFull.await();
            }
            if(++addTask==items.length){
                addTask=0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }


    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException{
        lock.lock();
        try {
            while (count==0){
                notEmpty.await();
            }
            Object x=items[removeIndex];
            if(++removeIndex==items.length){
                removeIndex =0;
            }
            --count;
            notFull.signal();
            return (T)x;
        }finally {
            lock.unlock();
        }
    }
}

