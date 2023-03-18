package com.java8的新特性;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/9/19 21:01
 */
public class jiexi {
    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();

//API的日期格式
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String strDate1 = ldt.format(dtf1);
        System.out.println(strDate1);

//自定义日期格式
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
        String strDate2 = ldt.format(dtf2);
        System.out.println(strDate2);

//字符串时间转换为LocalDateTime
        LocalDateTime dateTime =  LocalDateTime.parse(strDate2, dtf2);
        System.out.println(dateTime);

    }
}
