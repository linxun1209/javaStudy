package com.并发.Test;

import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/14 20:23
 */
public class TestUnsafe {
    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state=0;
    static {
        try {
            Field file=Unsafe.class.getDeclaredField("theUnsafe");
            file.setAccessible(true);
            unsafe=(Unsafe) file.get(null);
            stateOffset=unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafe test=new TestUnsafe();
        Boolean success=unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
