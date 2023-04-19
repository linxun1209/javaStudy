package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/13 9:35
 */
public class DeadLockTest2 {
    private static Object resourceA=new Object();
    private static Object resourceB=new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println((Thread.currentThread() + "get ResourceA"));
                    try{
                        Thread.sleep(1000);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"wait get sourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+"get ResourceB");

                    }
                };
            }
        });


        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println((Thread.currentThread() + "get ResourceB"));
                    try{
                        Thread.sleep(1000);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"wait get sourceA");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+"get ResourceA");

                    }
                };
            }
        });
//        Thread threadB=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resourceA){
//                    System.out.println((Thread.currentThread() + "get ResourceB"));
//                    try{
//                        Thread.sleep(1000);
//
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread()+"wait get sourceA");
//                    synchronized (resourceB){
//                        System.out.println(Thread.currentThread()+"get ResourceA");
//
//                    }
//                };
//            }
//        });


        threadA.start();
        threadB.start();




    }
}
