package com.并发.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/14 19:45
 */
public class ThreadNotSafeCount {
    private Long value;

    public synchronized Long get(){
        return value;
    }
    public synchronized void inc(){
        ++value;
    }
}
