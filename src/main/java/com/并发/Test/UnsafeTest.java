package com.并发.Test;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.misc.Unsafe;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/14 20:12
 */
public class UnsafeTest {

    //获取实例
    static final Unsafe unsafe=Unsafe.getUnsafe();
    //记录state变量在类中的偏移值

    static final long stateOffset;

    private volatile  long state=0;

    static {
        try {
            stateOffset=unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("statee"));

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeTest unsafeTest=new UnsafeTest();
        Boolean success=unsafe.compareAndSwapInt(unsafeTest,stateOffset,0,1);
        System.out.println(success);
    }

}
