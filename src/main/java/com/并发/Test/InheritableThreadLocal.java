//package com.并发.Test;
//
///**
// * @author xingchen
// * @version V1.0
// * @Package com.并发.Test
// * @date 2023/4/13 22:47
// */
//public class InheritableThreadLocal<T> extends ThreadLocal{
//
//
//    /**
//     * 
//     * @param parentValue
//     * @return
//     */
//    protected T childValue(T parentValue){
//        return parentValue;
//    }
//    ThreadLocalMap.getMap(Thread t){
//        return t.inheritableThreadLocals;
//    }
//    void create(Thread t,T firstValue){
//        t.inheritableLocals=new TestThreadLocalMap(this,firstValue);
//    }
//}
