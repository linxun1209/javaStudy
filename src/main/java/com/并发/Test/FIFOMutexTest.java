package com.并发.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/21 14:44
 */
public class FIFOMutexTest {
    private final AtomicBoolean locked=new AtomicBoolean(false);
    private final Queue<Thread> waiters=new ConcurrentLinkedDeque<>();
    public void lock(){
        boolean wasInterrupted=false;
        Thread current=Thread.currentThread();
        waiters.add(current);

        while (waiters.peek()!=current||!locked.compareAndSet(false,true)){
            LockSupport.park(this);
            if(Thread.interrupted()){
                wasInterrupted=true;
            }
        }



    }
    public void unlock(){
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}
