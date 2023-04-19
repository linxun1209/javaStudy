package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/16 13:11
 */
public class HelloTest {
    public synchronized void helloA(){
        System.out.println("helloA");
    }
    public synchronized void helloB(){
        System.out.println("hello B");
        helloA();
    }
}
