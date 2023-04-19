package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/13 16:44
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        /**
         * 只需要设置参数为true就开启了守护线程
         *
         */
        thread.setDaemon(true);
        thread.start();
    }
}
