package com.面试相关;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/19 22:52
 */
public class ClassTest {
    public static void main(String[] args) throws Exception {
        String className = "java.util.Date";
        Class<?> cls = Class.forName(className);
        Object obj = cls.newInstance();
        System.out.println(obj.getClass().getName());

// 加载并实例化类

// 获取并调用方法
        Method method = cls.getMethod("getTime");
        Object result = method.invoke(obj);
        System.out.println("Time: " + result);

// 访问字段
        Field field = cls.getDeclaredField("fastTime");
        field.setAccessible(true); // 对于私有字段需要这样做
        System.out.println("fastTime: " + field.getLong(obj));
    }
}

