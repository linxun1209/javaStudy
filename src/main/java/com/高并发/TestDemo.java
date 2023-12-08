package com.高并发;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平/非公平锁演示
 */
public class TestDemo {
    public static void main(String[] args)throws Exception {
        ReentrantLock lock = new ReentrantLock(false);
        // 线程1
        new Thread(()->{
            lock.lock(); // 加锁
            add();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();// 解锁
        },"t1").start();



        // 线程2
        new Thread(()->{
            lock.lock(); // 加锁
            add();
            lock.unlock();// 解锁
        },"t2").start();

        new Thread(()->{
            lock.lock(); // 加锁
            add();
            lock.unlock();// 解锁
        },"t3").start();

        for (int j = 0; j < 100000; j++) {
            new Thread(()->{
                lock.lock(); // 加锁
                add();
                lock.unlock();// 解锁
            }).start();
        }




    Thread.sleep(30000);
        System.out.println(i);
    }
    static int i =0;
    public  static void add() {
        i++;
        System.out.println(Thread.currentThread().getName()+"获得了锁");
    }
}
