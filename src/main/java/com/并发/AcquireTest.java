//package com.并发;
//
//import com.linxun.leetcode.Node;
//
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.LockSupport;
//
///**
// * @author xingchen
// * @version V1.0
// * @Package com.并发
// * @date 2023/4/3 22:18
// */
//public class AcquireTest {
//    public final void acquire(int arg){
//        if(!tryAcquire(arg))&&acquireQueued(addWaiter(Node.EXCLUSIVE),arg);
//        selfInterrupt();
//    }
//    private Node addWait(Node mode){
//        Node node=new Node(Thread.currentThread(),mode);
//        Node pred =tail;
//        while (pred!=null){
//            node.prev =pred;
//            if(CompareAndSetTail(pred,node)){
//                pred.next=node;
//                return node;
//            }
//        }
//        enq(node);
//        return node;
//    }
//    private Node enq(final Node node){
//        for (; ;){
//            Node t=tail;
//            if(t==null){
//                if(compareAndSetHead(new Node())){
//                    tail=head;
//                }else {
//                    node.prev=t;
//                    if(compareAndSetTail(t,node)){
//                        t.next=node;
//                        return t;
//                    }
//                }
//            }
//        }
//    }
//
//    final boolean acquireQueued(final Node node,int arg){
//        boolean failed=true;
//        boolean interrupt= false;
//        try {
//            interrupt = false;
//            for(; ; ){
//                final Node p=node.predecesspr();
//                if(p==head&&tryAcquire(arg)){
//                    setHead(node);
//                    p.next=null;
//                    failed=false;
//                    return interrupt;
//                }
//                if(shouldParkAfterFailedAcquire(p,node)&&packAndCheckInterrupt()){
//                    interrupt=true;
//                }
//            }
//        } finally {
//            if(failed){
//                cancelAcquire(node);
//            }
//        }
//
//    }
//
//    public final boolean release(int arg){
//        if(tryRelease(arg)){
//            Node h=head;
//            if(h!=null&&h.waitStaue!=0){
//                unparkSuccessor(h);
//            }
//            return true;
//        }
//        return false;
//    }
//    public final void acquireShared(int arg) {
//        if (tryAcquireShared(arg) < 0) {
//            doAcquireShared(arg);
//        }
//    }
//
//    private void doAcquireShared(int arg) {
//        final AbstractQueuedSynchronizer.Node node = addWaiter(AbstractQueuedSynchronizer.Node.SHARED);
//        boolean failed = true;
//        try {
//            boolean interrupted = false;
//            for (;;) {
//                final AbstractQueuedSynchronizer.Node p = node.predecessor();
//                if (p == head) {
//                    int r = tryAcquireShared(arg);
//                    if (r >= 0) {
//                        setHeadAndPropagate(node, r);
//                        p.next = null; // help GC
//                        if (interrupted)
//                            selfInterrupt();
//                        failed = false;
//                        return;
//                    }
//                }
//                if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt())
//                    interrupted = true;
//            }
//        } finally {
//            if (failed)
//                cancelAcquire(node);
//        }
//    }
//
//    public final boolean releaseShared(int arg) {
//        if (tryReleaseShared(arg)) {
//            doReleaseShared();
//            return true;
//        }
//        return false;
//    }
//
//    private boolean doAcquireNanos(int arg, long nanosTimeout)
//            throws InterruptedException {
//        if (nanosTimeout <= 0L)
//            return false;
//        final long deadline = System.nanoTime() + nanosTimeout;
//        final AbstractQueuedSynchronizer.Node node = addWaiter(AbstractQueuedSynchronizer.Node.EXCLUSIVE);
//        boolean failed = true;
//        try {
//            for (;;) {
//                final AbstractQueuedSynchronizer.Node p = node.predecessor();
//                if (p == head && tryAcquire(arg)) {
//                    setHead(node);
//                    p.next = null; // help GC
//                    failed = false;
//                    return true;
//                }
//                nanosTimeout = deadline - System.nanoTime();
//                if (nanosTimeout <= 0L)
//                    return false;
//                if (shouldParkAfterFailedAcquire(p, node) &&
//                        nanosTimeout > spinForTimeoutThreshold)
//                    LockSupport.parkNanos(this, nanosTimeout);
//                if (Thread.interrupted())
//                    throw new InterruptedException();
//            }
//        } finally {
//            if (failed)
//                cancelAcquire(node);
//        }
//    }
//
//
//
//
//}
