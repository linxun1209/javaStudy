package com.并发.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/21 14:30
 */
public class TestPark {
    public void testPark(){
        LockSupport.park();

    }

    public static void main(String[] args) {
        TestPark testPark=new TestPark();
        testPark.testPark();
    }


}
