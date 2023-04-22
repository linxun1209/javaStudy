package com.并发.Test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/21 13:42
 *
 * 学习弱一致性案例
 */
public class CopyListTest {

    private static volatile CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException{
        arrayList.add("hello");
        arrayList.add("hello");
        arrayList.add("hello");
        arrayList.add("hello");
        arrayList.add("hello");
        arrayList.add("hello");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1,"baba");
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });


        Iterator<String > iterator=arrayList.iterator();
        thread.start();
        thread.join();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
