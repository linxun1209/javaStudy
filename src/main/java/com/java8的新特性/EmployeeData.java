package com.java8的新特性;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.java8的新特性
 * @date 2022/11/2 21:38
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(100,"星辰",22,122));
        list.add(new Employee(100,"星辰",22,122));
        list.add(new Employee(100,"星辰",22,122));
        list.add(new Employee(100,"星辰",22,122));
        list.add(new Employee(100,"星辰",22,122));
        list.add(new Employee(100,"星辰",22,122));
        return list;


    }
}
