package com.java8的新特性;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/9/19 21:02
 */
public class shiqu {
    public static void main(String[] args) {
        //获取所有的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);

    }
}
