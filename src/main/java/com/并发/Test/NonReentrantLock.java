package com.并发.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/29 13:43
 */
public class NonReentrantLock implements Lock ,java.io.Serializable {

   private static class Sync extends AbstractQueuedSynchronizer{
       @Override
       protected boolean isHeldExclusively(){
           return getState()==1;
       }
       @Override
       public boolean tryAcquire(int acquires){
           assert acquires==1;
           if(compareAndSetState(0,1)){
               setExclusiveOwnerThread(Thread.currentThread());
               return true;
           }
           return false;
       }


       @Override
       protected boolean tryRelease(int releases){
           assert releases==1;
           if(getState()==0){
               throw new IllegalMonitorStateException();
           }
           setExclusiveOwnerThread(null);
           setState(0);
           return true;
       }

       public Condition newCondition() {
           return new ConditionObject();
       }
   }

   private final Sync sync=new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }


    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }


    @Override
    public void lockInterruptibly() throws InterruptedException{
        sync.acquireInterruptibly(1);
    }



    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {

            return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
        }

}
