package com.并发.线程的创建;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.线程的创建
 * @date 2023/4/2 15:53
 *
 *
 *
 *
 *
 *
 *
 *
 * 1.使用继承的好处是方便传参,可以在子类里面添加成员方法
 *   通过set或者构造函数进行参数传递
 * 2.使用Runnable则只能使用主线程里面被声明的final变量.不好的地方是java不支持多继承
 * 3.继承Thread那么子类不能再继承其他类 而Runnable没有这个限制
 * 4.前两个方法都不支持返回参数,最后的Futuretask方式可以
 *
 */
public class ThreadTest {


    /**
     * 第一种实现多线程的方式
     *
     * 优点:
     *      在run()方法内获取当前线程不需要使用Thread.currentThread()方法,直接使用this就可以获取当前线程
     * 缺点:
     *      java不支持多继承,如果继承Thread就不能继承其他父类
     *      任务和代码没分离,当多个线程执行一样的任务时候需要多份认任务代码
     *      任务方法没有返回值
     */
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a Thread");
        }
    }


    /**
     * 第二种创建线程的方法
     *
     * 优点:
     *  任务跟代码分离开
     * 缺点:
     *  任务方法没有返回值
     */
    public static class RunableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("I am a Thread2");
        }
    }



    public static class CallTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "hello Thread";
        }
    }



    public static void main(String[] args) throws InterruptedException{
        /**
         *创建线程的时候其实还没有成功启动,只有执行了线程的start方法的时候才算真正启动成功
         * 用操作系统的角度来看创建线程的时候其实处在了就绪态(已经获取了除了CPU之外的其他资源)
         * 执行start会执行线程的run方法,就获得了cpu从就绪态转到了运行态
         * run方法结束标志该线程运行完成处于终止状态
         *
         */
        MyThread myThread = new MyThread();

        //线程启动
        myThread.start();;

        RunableTask runableTask = new RunableTask();
        new Thread((runableTask)).start();;
        new Thread((runableTask)).start();


        FutureTask<String> futureTask = new FutureTask<>(new CallTask());
        new Thread(futureTask).start();

        try {
            String string = futureTask.get();
            System.out.println(string);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        

    }
}
