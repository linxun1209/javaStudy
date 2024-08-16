package com.面试相关;

class Person {
   void work() {
       System.out.println("工作");
   }
}

class Student extends Person {
   @Override
   void work() {
       System.out.println("上学");
   }
}

public class Test {
   public static void main(String[] args) {
       Person person = new Student();
       person.work(); // 输出 "上学"
   }
}
