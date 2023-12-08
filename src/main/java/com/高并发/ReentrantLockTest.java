package com.高并发;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 使用演示
 */
public class ReentrantLockTest {
    public static void main(String[] args)throws Exception {
        ReentrantLock lock = new ReentrantLock();
        // 线程1
        new Thread(()->{
            lock.lock(); // 加锁
            add();
            lock.unlock();// 解锁
        }).start();
        // 线程2
        new Thread(()->{
            lock.lock(); // 加锁
            add();
            lock.unlock();// 解锁
        }).start();
    Thread.sleep(3000);
        System.out.println(i);
    }
    static int i =0;
    public  static void add() {
        i++;
    }
}