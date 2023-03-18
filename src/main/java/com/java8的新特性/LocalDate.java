package com.java8的新特性;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/9/19 20:58
 */
public class LocalDate {
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

//TemporalAdjusters 静态方法对TemporalAdjuster的实现 | 下个周日
        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

//TemporalAdjuster 自定义：下个工作日
        LocalDateTime ldt4 = ldt1.with(l->{
            LocalDateTime ldt5 = (LocalDateTime) l;

            DayOfWeek dayOfWeek = ldt5.getDayOfWeek();
            if(dayOfWeek.equals(DayOfWeek.FRIDAY)){
                return ldt5.plusDays(3);
            }else if(dayOfWeek.equals(DayOfWeek.SATURDAY)){
                return ldt5.plusDays(2);
            }else{
                return ldt5.plusDays(1);
            }
        });
        System.out.println(ldt4);


    }
}
