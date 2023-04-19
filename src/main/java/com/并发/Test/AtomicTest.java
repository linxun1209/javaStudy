package com.并发.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/17 17:28
 */
public class AtomicTest {
    private static AtomicLong atomicLong=new AtomicLong();
    private static Integer[] arrayOne=new Integer[]{0,1,2,3,4,5,6,7,56,0};
    private static Integer[] arrayTwo=new Integer[]{10,1,2,3,4,5,6,0,56,0};

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for(int i=0;i<size;i++){
                    if(arrayOne[i].intValue()==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        Thread threadTwo=new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for(int i=0;i<size;i++){
                    if(arrayTwo[i].intValue()==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });


        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("count 0:"+atomicLong.get());

    }
}
