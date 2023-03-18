package com.java8的新特性;


import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/9/19 20:5 */
public class InstantDemo {
    public static void main(String[] args) {

        Instant ins = Instant.now();  //默认使用 UTC 时区
        System.out.println(ins);
        System.out.println(ins.getEpochSecond());
        System.out.println(ins.toEpochMilli());

        Instant ins2 = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));  //东8区
        System.out.println(ins2);
        System.out.println(ins2.getEpochSecond());
        System.out.println(ins2.toEpochMilli());

    }
}
