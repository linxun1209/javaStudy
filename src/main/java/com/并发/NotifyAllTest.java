package com.并发;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/2 21:04
 */
public class NotifyAllTest {
    private static volatile Object resourceA=new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadA get resocuseA lock");
                    try {
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB get resocuseA lock");
                    try {
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
        Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("thread begin notify");
                    resourceA.notify();

                }
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("over");
    }
}
