package com.Student;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.Student
 * @date 2022/9/17 17:12
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : cunyu
 * @version : 1.0
 * @className : Manager
 * @date : 2021/4/4 23:54
 * @description : 管理系统
 */

public class Manager {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----------欢迎使用学生成绩管理系统-----------");
            System.out.println("-------------【1】录入学生成绩-------------");
            System.out.println("-------------【2】显示统计数据-------------");
            System.out.println("-------------【3】查找学生成绩-------------");
            System.out.println("-------------【4】修改学生成绩-------------");
            System.out.println("-------------【5】删除学生成绩-------------");
            System.out.println("-------------【6】按平均分排列-------------");
            System.out.println("-------------【7】显示所有成绩-------------");
            System.out.println("-------------【0】退出管理系统-------------");

            Student student = new Student();

            System.out.println("输入你的选择");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    student.addScore(students);
                    break;
                case "2":
                    student.showAvg(students);
                    break;
                case "3":
                    student.lookupStudent(students);
                    break;
                case "4":
                    student.modifyStudent(students);
                    break;
                case "5":
                    student.deleteStudent(students);
                    break;
                case "6":
                    student.sortStudent(students);
                    break;
                case "7":
                    student.showAllStudent(students);
                    break;
                case "0":
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}


