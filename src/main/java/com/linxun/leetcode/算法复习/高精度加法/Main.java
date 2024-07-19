package com.linxun.leetcode.算法复习.高精度加法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

   public static void main(String[] args) throws IOException {
       // 由于数据量较大，使用BufferedReader读取数据
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       String A = in.readLine();  
       List<Integer> aList = new ArrayList<>();
       for (int i = A.length() - 1; i >= 0; i--) {  
          aList.add(A.charAt(i) - '0');  
       }  
       String B = in.readLine();  
       List<Integer> bList = new ArrayList<>();  
       for (int i = B.length() - 1; i >= 0; i--) {  
          bList.add(B.charAt(i) - '0');  
       }  
       List<Integer> cList = add(aList, bList);  
       for (int i = cList.size() - 1; i >= 0; i--) {  
          System.out.print(cList.get(i));  
       }  
       // 关闭资源
       in.close();
    }

   /**  
    * 大数据加法  
    */
   private static List<Integer> add(List<Integer> A, List<Integer> B) {
       // 默认A > B，如果不满足则对调
       if (A.size() < B.size()) {
           return add(B, A);
       }
       int t = 0;
       List<Integer> C = new ArrayList<>();
       for (int i = 0; i < A.size(); i++) {
           t += A.get(i);
           // 如果在B的范围内，则加B
           if (i < B.size()) {
               t += B.get(i);
           }
           // C记录余数
           C.add(t % 10);
           t /= 10;
       }
       // 进位
       if (t != 0) {
           C.add(t);
       }
       // 去掉开头的零
       while (C.size() > 1 && C.get(C.size() - 1) == 0) {
           C.remove(C.size() - 1);
       }
       return C;
   }
}