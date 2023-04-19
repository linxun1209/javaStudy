package com.并发.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/12 23:38
 */
public class InterruptedExceptionTest {

    //创建一个独占锁
    private static final Lock lock=new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(1000);
                    System.out.println("child threadA is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });


        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");
                    Thread.sleep(1000);
                    System.out.println("child threadB is in awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });


        threadOne.start();

        threadTwo.start();

    }

}
