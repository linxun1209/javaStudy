package com.并发;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/3 17:41
 *
 *  同步器锁
 *
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedLongSynchronizer{
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }


        /**
         * 当状态为0的时候获取锁
         *
         * @param arg
         * @return
         */
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }



        /**
         * 释放锁 将状态设置为零
         *
         */
        protected boolean tryRelease(int releases) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 返回一个Condition
         * 每个condition都包含一个condition队列
         *
         */
        Condition newCondition(){
            return new ConditionObject();
        }


    }


    /**
     * 仅需要将操作代理到Sync上即可
     */
    private final Sync sync=new Sync();

    @Override
    public void lock() {
        sync.acquire(1);

    }


    @Override
    public boolean tryLock(){
        return sync.tryAcquire(1);
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }




    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);

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

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }


}
