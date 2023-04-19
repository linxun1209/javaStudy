package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/12 23:42
 */
public class SleepTest2 {


    public static void main(String[] args) throws InterruptedException{
        Thread threadOne =new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadOne begin run!!!");
                    for(; ; ){

                    }
                }
            });


            final Thread mainThread=Thread.currentThread();



            Thread threadTwo =new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    mainThread.interrupt();
                }
            });



            threadOne.start();

            threadTwo.start();


            try {
                threadOne.join();
            } catch (InterruptedException e) {
                System.out.println("main thread "+e);
            }
        }

}
