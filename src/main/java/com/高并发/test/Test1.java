package com.高并发.test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.高并发.test
 * @date 2023/3/5 10:22
 */

import lombok.extern.slf4j.Slf4j;

/**
 * @author xing'chen
 */
@Slf4j(topic = "c.Test1")
public class Test1 {

    public static void test2() {

        Thread t = new Thread(()->{ log.debug("running"); }, "t2");

        t.start();
    }
    public static void test1() {
        Thread t = new Thread(){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        t.setName("t1");
        t.start();

    }
}