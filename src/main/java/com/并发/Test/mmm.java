//package com.并发.Test;
//
///**
// * @author xingchen
// * @version V1.0
// * @Package com.并发.Test
// * @date 2023/4/13 21:52
// */
//public class mmm {
//    public void set(T value){
//        Thread t=Thread.currentThread();
//        ThreadLoalMap map=getMap(t);
//        if(map!=null){
//            map.set(this,value);
//
//        }else {
//            createMap(t,value);
//        }
//    }
//
//    ThreadLocalMap getMap(Thread t){
//        return t.threadLocals;
//    }
//
//    void createMap(Thread t,T firstValue){
//        t.threadLocals=new ThreadLocalMap(this,firstValue);
//    }
//
//
//    public void get(){
//
//        //获取当前线程
//        Thread t=Thread.currentThread();
//        //获取当前线程的threadLocxals变量
//        ThreadLocalMap map=getMap(t);
//        //如果ThreadLocals不为空,则返回对应的本地变量
//        if(map!=null){
//            ThreadLocalMap.Entry e=map.getEntry(this);
//        }
//        if(e!=null){
//            @SuppressWarnings("unchecked")
//             T result=(T) e.value;
//            return result;
//        }
//        //为空初始化当前线程的ThreadLocals成员变量
//        return setInitialValue;
//    }
//
//    private T setInitialValue(){
//        //初始化为null
//        T value =initialValue;
//        Thread t=Thread.currentThread();
//        ThreadLocalMap map=getMap(t);
//        //如果当前线程的本地变量不为空
//        if(map!=null){
//            map.set(this,value);
//
//        }else {
//            //如果当前线程的本地变量为空 则创建
//            createMap(t,value);
//
//        }
//        return value;
//    }
//    private T initialValue(){
//        return null;
//    }
//
//
//    /**
//     * 如果当前线程的threadLocals变量不为空,则删除当前线程中指定ThreadLocal实例的本地变量
//
//     */
//    public void remove(){
//        ThreadLocalMap map=getMap(Thread.currentThread());
//        if(m!=null){
//            m.remove(this);
//
//        }
//
//    }
//
//
//
//
//
//}
