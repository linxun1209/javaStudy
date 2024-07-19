package com;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/7/16 10:33
 */
public class test {





    @Test
    public void test1(){

        String classpath = this.getClass().getResource("/").getPath();
        classpath.getBytes(StandardCharsets.UTF_8);
        System.out.println(classpath);
    }

}

