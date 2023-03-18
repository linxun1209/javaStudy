package com.星火算法训练;//package com.星火算法训练;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @author xingchen
// * @version V1.0
// * @Package com.星火算法训练
// * @date 2022/12/7 20:18
// */
//public class 语句解析 {
//    public static void main(String[] args) {
//        Map<String,Integer> map=new HashMap<>();
//        String st;
//        Scanner scanner=new Scanner(System.in);
//        st=scanner.next();
//        int len=st.length();
//        map.put("a",2);
//        map.put("b",0);
//        map.put("c",0);
//        char[] chars=st.toCharArray();
//        for (int i = 0; i < len; i+=5) {
//            if(chars[i+3]>='0'&&chars[i+3]<='9') {
//                System.out.println(map.);
//            }
//
//
//        }
//        System.out.println(0);
//
//    }
//}
import java.util.*;
public class 语句解析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        char a = '0';
        char b = '0';
        char c = '0';
        for (int i = 0; i < x.length(); i+=5) {
            if (x.charAt(i) == 'a'){
                if (x.charAt(i+3) == 'a'){
                } else if (x.charAt(i+3) == 'b') {
                    a = b;
                } else if (x.charAt(i+3) == 'c') {
                    a = c;
                }else {
                    a = x.charAt(i+3);
                }
            } else if (x.charAt(i) == 'b') {
                if (x.charAt(i+3) == 'a'){
                    b = a;
                } else if (x.charAt(i+3) == 'b') {
                } else if (x.charAt(i+3) == 'c') {
                    b = c;
                }else {
                    b = x.charAt(i+3);
                }
            } else if (x.charAt(i) == 'c') {
                if (x.charAt(i+3) == 'a'){
                    c = a;
                } else if (x.charAt(i+3) == 'b') {
                    c = b;
                } else if (x.charAt(i+3) == 'c') {
                }else {
                    c = x.charAt(i+3);
                }
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}