package com.并发.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/21 14:07
 */
public class parkTest {
    public static void main(String[] args) {

        LockSupport.unpark(Thread.currentThread());
        System.out.println("begin park");
        LockSupport.park();
        System.out.println("end park");
    }
}
