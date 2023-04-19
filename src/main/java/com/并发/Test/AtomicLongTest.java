package com.并发.Test;

import sun.misc.Unsafe;
import sun.misc.VMSupport;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/17 16:44
 */
public class AtomicLongTest extends Number implements Serializable {


    private static final long serialVersionUID= 1927816293512124184L;

    private static final Unsafe unsafe =Unsafe.getUnsafe();


    private static final long valueOffset;

    static final boolean VM_SUPPORTS_LONG_CAS= VMSupportsCS8();
    private static native boolean VMSupportsCS8();

    static {
        try{
            valueOffset = unsafe.objectFieldOffset(AtomicLongTest.class.getDeclaredField("value"));

        }catch (Exception e){
            throw new Error(e);
        }

    }
    private volatile long value;
    private  AtomicLongTest(long initiaValue){
        value=initiaValue;
    }
    @Override
    public int intValue() {
        return 0;
    }


    @Override
    public long longValue() {
        return 0;
    }


    @Override
    public float floatValue() {
        return 0;
    }


    @Override
    public double doubleValue() {
        return 0;
    }

}
