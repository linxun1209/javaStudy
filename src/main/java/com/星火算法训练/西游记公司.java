package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/12/7 21:35
 */
public class 西游记公司 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String l = sc.next();
        int v = sc.nextInt();
        long t1 = 0;
        long t2 = 0;
        int s1 = 3600;
        int s2 = 3600;
        int a1 = 0;
        int b1 = 0;
        int a2 = 0;
        int b2 = 0;
        int o1 = x.length();
        int o2 = l.length();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ':'){
                for (int j = i-a1; j < i; j++) {
                    t1 += (x.charAt(j)-48)*Math.pow(10,a1-1)*(s1/Math.pow(60,b1));
                    a1--;
                }
                b1++;
            }else {
                a1++;
            }
            if (b1 == 2){
                o1 = i;
                b1++;
            }
            if (i > o1) {
                t1 += (x.charAt(i)-48)*Math.pow(10,x.length()-1-i);
            }
        }
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == ':'){
                for (int j = i-a2; j < i; j++) {
                    t2 += (l.charAt(j)-48)*Math.pow(10,a2-1)*(s2/Math.pow(60,b2));
                    a2--;
                }
                b2++;
                if (b2 == 2){
                    o2 = i;
                    b2++;
                }
            }else {
                a2++;
            }
            if (i > o2) {
                t2 += (l.charAt(i)-48) * Math.pow(10, l.length() - 1 - i);
            }
        }
        System.out.println((t2-t1)*v);
    }
}