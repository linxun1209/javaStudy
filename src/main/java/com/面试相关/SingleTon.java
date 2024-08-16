package com.面试相关;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 双重检查锁定（double-checked locking）
 * @date 2024/8/16 16:51
 */
public class SingleTon {
    //volatile防止指令重排序  将会保证对所有线程的可见性。
    private static volatile SingleTon instance=null;


    //无参构造
    private SingleTon(){

    }


    public static SingleTon getInstance(){
        if(instance==null){
            //同步代码块。只有在第一次获取对象的时候才会执行到，第二次及以后访问时，instance变量均为非null
            synchronized(SingleTon.class){
                if(instance==null){
                    instance=new SingleTon();
                }
            }
        }
        return instance;
    }

}

