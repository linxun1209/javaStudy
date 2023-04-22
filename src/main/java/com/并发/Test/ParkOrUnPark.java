package com.并发.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/21 14:16
 */
public class ParkOrUnPark {
    public static void main(String[] args) throws InterruptedException{
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");

                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }


                System.out.println("child thread unpark");

            }
        });

        thread.start();
        Thread.sleep(1000);

        System.out.println("main thread begin unpark!");

        thread.interrupt();

    }
}
