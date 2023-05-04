package com.并发.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/29 13:09
 */
public class AQSTest {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        lock.lock();
        try{
            System.out.println("begin wait");
            condition.wait();
            System.out.println("end wait");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();

        }
        try{
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

}
