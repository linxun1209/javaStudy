package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/14 13:24
 */
public class ThreadNotSafeIntegerTest {
    private volatile int value;
    public  int get(){
        return value;
    }

    public void set(int value){
        this.value=value;
    }
}

