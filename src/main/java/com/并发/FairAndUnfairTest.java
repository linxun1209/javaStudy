package com.并发;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/4 11:21
 */
public class FairAndUnfairTest {
    private static Lock fairLock =new ReentrantLock2(true);
    private static Lock unfairLock =new ReentrantLock2(true);


    public  void fair(){
        testLock(fairLock);
    }


    public void unfair(){
        testLock(unfairLock);
    }

    private void testLock(Lock lock){
        //自定义十次Job任务

    }


    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock=lock;
        }

        @Override
        public void run() {
//            super.run();
            //连续两次打印当前线程和等待线程的名字
        }
    }


    private static class ReentrantLock2 extends ReentrantLock{
        public  ReentrantLock2(boolean fair){
            super(fair);
        }
        public Collection<Thread> getQueueTgreads(){
            List<Thread> arrayList=new ArrayList<>(super
                    .getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
