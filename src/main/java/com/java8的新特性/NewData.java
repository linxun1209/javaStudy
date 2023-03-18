package com.java8的新特性;

import java.time.LocalDateTime;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/9/19 20:52
 */
public class NewData {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.of(2016, 11, 21, 10, 10);
        System.out.println(dateTime2);
//增加
        LocalDateTime dateTime3 = dateTime2.plusDays(5);
        System.out.println(dateTime3);
//减少
        LocalDateTime dateTime4 = dateTime3.minusDays(2);
        System.out.println(dateTime4);

    }

}
