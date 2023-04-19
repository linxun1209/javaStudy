package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/13 8:48
 */
public class InterruptTest implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
//    @Override
//    public void run() {
//        try {
//            while (!Thread.currentThread().isInterrupted()&&more work to do){
//                //do more work
//            }
//        }catch (InterruptedException e){
//            //thread was interrupted during sleep or wait
//        }finally {
//            //cleanup if required
//        }
//    }


    public static void main(String[] args) throws InterruptedException{
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread()+"hello");
                }
            }
        });


        thread.start();


        Thread.sleep(1000);
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        thread.join();
        System.out.println("main is over");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}
