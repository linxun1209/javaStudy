package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/14 20:36
 */
public  class MoreThreadTest {


    /**
     * 这段代码没有声明volatile变量,也没有使用任何同步措施
     * 多线程下存在共享内存可见性问题
     * 可以通过对共享变量声明成volatile就可以避免指令重排序问题
     */
    public static class ReadThread extends Thread{
        @Override
        public void run(){
            while (!Thread.currentThread().isInterrupted()){
                if(ready){
                    System.out.println(num+num);
                }
                System.out.println("read thread");
            }
        }

    }
    public static class WriteThread extends Thread{
        @Override
        public void run(){
            num=2;
            ready=true;
            System.out.println("writeThread set over");
        }
    }
    private static int num =0;
    private static boolean ready=false;

    public static void main(String[] args) throws InterruptedException{
        ReadThread readThread=new ReadThread();
        readThread.start();
        WriteThread writeThread=new  WriteThread();
        writeThread.start();
        Thread.sleep(1000);
        readThread.interrupt();
        System.out.println("main exit");

    }

}

