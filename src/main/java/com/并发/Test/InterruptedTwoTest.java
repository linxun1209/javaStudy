package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/13 8:58
 */
public class InterruptedTwoTest {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread begin sleep for 2000 second");
                    Thread.sleep(200000);
                    System.out.println("threadOne awake");
                }catch (InterruptedException e){
                    System.out.println("threadOne is Interrupted while sleeping");

                }
            }
        });


        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }
}
