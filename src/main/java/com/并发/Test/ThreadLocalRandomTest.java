package com.并发.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/16 22:14
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom random=ThreadLocalRandom.current();
        for (int i=0;i<10;i++){
            System.out.println(random.nextInt(5));
        }

    }
}
