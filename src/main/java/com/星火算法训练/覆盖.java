package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/11/12 17:05
 */
public class 覆盖{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        int c = a.length();
        a = a.concat("     ");
        int b = 0,g = 0;
        for (int i = 0; i < c; i++) {
            if (a.charAt(i) == 'b'|| a.charAt(i + 1) == 'o'|| a.charAt(i + 2) == 'y') {
                b++;
            }
            if (a.charAt(i) == 'g'||a.charAt(i + 1) == 'i'|| a.charAt(i + 2) == 'r' || a.charAt(i + 3) == 'l') {
                g++;
            }
        }
        System.out.println(b);
        System.out.println(g);
    }
}
