package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/13 22:33
 */
public class TestThreadLocal1 {
    public static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    public static void main(String[] args){
        threadLocal.set("hello world");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:"+threadLocal.get());

            }
        });
        thread.start();
        System.out.println("main:"+threadLocal.get());
    }
}
