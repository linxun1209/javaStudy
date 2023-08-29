package com.面试相关.day02.threadsafe;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.面试相关.day02.threadsafe
 * @date 2023/8/26 21:22
 */

public class MyData {

    private volatile int number=1;
    public void addNum(){
        number++;
    }

    public static void main(String[] args) {
        MyData myData = new MyData();

        // 启动20个线程，每个线程将myData的number值加1000次，那么理论上number值最终是20000
        for (int i=0; i<20; i++) {
            new Thread(() -> {
                for (int j=0; j<1000; j++) {
                    myData.addNum();
                }
            }).start();
        }

        // 程序运行时，有主线程和垃圾回收线程也在运行。如果超过２个线程在运行，那就说明上面的20个线程还有没执行完的，就需要等待

        while (Thread.activeCount()>2){
            Thread.currentThread().getThreadGroup().activeCount();
            Thread.yield();// 交出CPU 执行权
        }
        System.out.println("number值加了20000次，此时number的实际值是：" + myData.number);
    }

}