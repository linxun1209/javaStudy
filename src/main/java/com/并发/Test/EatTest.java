package com.并发.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/29 14:00
 */
public class EatTest {
    final static NonReentrantLock lock=new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty=lock.newCondition();

    final static Queue<String> queue=new LinkedBlockingQueue<String>();
    final static int queueSize=10;

    public static void main(String[] args) {
        Thread producer=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{

                    //队列满了,等待
                    while (queue.size()==queueSize){
                        notEmpty.await();
                    }
                    //添加元素到队列
                    queue.add("ele");
                    //唤醒消费线程
                    notFull.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });



        Thread consumer =new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                        while (0==queue.size()) {
                            notFull.wait();
                        }
                       String ele=queue.poll();
                        notEmpty.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();

    }
}
