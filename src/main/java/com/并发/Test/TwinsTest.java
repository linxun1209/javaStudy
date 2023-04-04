//package com.并发.Test;
//
//
//import com.并发.TwinsLock;
//import lombok.SneakyThrows;
//import org.junit.Test;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Lock;
//
///**
// * @author xingchen
// * @version V1.0
// * @Package com.并发.Test
// * @date 2023/4/4 10:22
// */
//public class TwinsTest {
//
//    @Test
//    public void test(){
//        final Lock lock=new TwinsLock();
//        class Worker extends Thread{
//            @SneakyThrows
//            @Override
//            public void run() {
//                while (true){
//                    lock.lock();
//                    try {
//                        TimeUnit.SECONDS.sleep(1);//秒
//                        System.out.println(Thread.currentThread().getName());
//                        TimeUnit.SECONDS.sleep(1);//秒
//
//                    }
//                    finally {
//                        lock.unlock();
//                    }
//
//                }
//                for (int i=0;i<10;i++){
//                    Worker worker=new Worker();
//                    worker.setDaemon(true);
//                    worker.start();
//                }
//                for (int i=0;i<10;i++){
//                    TimeUnit.SECONDS.sleep(1);//秒
////
//                    System.out.println();
//                }
//            }
//
//        }
//    }
//}
