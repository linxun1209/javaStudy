package com.并发;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/2 20:16
 */
public class WaitNotifyInterupt {
    static Object object=new Object();
    public static void main(String[] args) throws InterruptedException{
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("--------begin--------");
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        Thread.sleep(1000);
        System.out.println("begin interrput threadA");
        threadA.interrupt();
        System.out.println("end interrupt threadA---");
    }




}
