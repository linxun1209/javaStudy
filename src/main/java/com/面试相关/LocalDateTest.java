package com.面试相关;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/19 23:03
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        LocalTime time = LocalTime.now();
        System.out.println("Local time : " + time);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current DateTime : " + now);
    }
}

