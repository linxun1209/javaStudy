package com.并发.Test;

import java.util.Random;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发.Test
 * @date 2023/4/16 22:02
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random=new Random();
        for (int i=0;i<10;i++){
            System.out.println(random.nextInt(5));
        }

    }
}
