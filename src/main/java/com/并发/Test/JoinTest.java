package com.并发.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/12 23:31
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over");
            }
        });




        Thread threadTwo =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threanTwo over");
            }
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over ");

        threadOne.join();
        threadTwo.join();

        System.out.println("all child over");
    }
}
