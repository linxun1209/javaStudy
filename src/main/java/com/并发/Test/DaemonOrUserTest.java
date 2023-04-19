package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/13 16:46
 */
public class DaemonOrUserTest {

    /**
     *thread线程里面是一个无限循环,运行之后主线程已经结束,但是jvm还没有退出
     * 说明父线程结束后,子线程还可以继续存在,也就是子线程的生命周期并不受父线程的影响
     * 也说明了在用户线程还存在的情况下JVM进程并不会终止
     *
     *
     *
     *
     * 设置成用户线程之后一旦主线程停止之后,jvm发现已经不存在用户线程了,就会终止JVN进程
     * 如果用户进程已经结束,但是守护线程还说运行,这个时候JVM不需要等待守护线程停止就直接结束JVM进程
     *
     *
     *
     *
     * main线程运行结束之后,JVM会自动启动一个DestroyJavaVm  的线程,该线程等待所有的用户线程结束后
     * 终止JVM进程
     *
     *
     */
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ;){

                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }



}
