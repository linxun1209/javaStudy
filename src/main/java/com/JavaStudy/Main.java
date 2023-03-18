package com.JavaStudy;

import java.lang.reflect.Field;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy
 * @date 2022/9/16 18:04
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

