package com.并发;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/13 9:03
 */
public class InterruptedOrIsInterrupted {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                for(; ;){

                }
            }
        });


        threadOne.start();

        threadOne.interrupt();

        System.out.println("isInterrupted:"+threadOne.isInterrupted());

//        System.out.println("isInterrupted"+threadOne.interrupted());

        System.out.println("isInterrupted:"+Thread.interrupted());

        System.out.println("isInterrupted:"+threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main thread is over");
    }



}
