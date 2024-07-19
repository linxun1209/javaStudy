package com.linxun.leetcode.算法复习.浮点数二分算法模板;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      double x = in.nextDouble();
      Double left = -Double.MAX_VALUE;
      Double right = Double.MAX_VALUE;
      // 由于负六次方精度不够
      while (right - left > 1e-8) {
         Double mid = (left + right) / 2;
         if (mid * mid * mid >= x) {
            right = mid;
         } else {
            left = mid;
         }
      }
      // 注意格式化输出字符串
      System.out.printf("%.6f", left);
   }
}
