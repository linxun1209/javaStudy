package com.并发;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/13 9:11
 */
public class InterruptedOrIsInterruptedTwo {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {

                }
                System.out.println("threadTwo isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });



        threadOne.start();

        threadOne.interrupt();


        threadOne.join();
        System.out.println("main thread is over");
    }
}
