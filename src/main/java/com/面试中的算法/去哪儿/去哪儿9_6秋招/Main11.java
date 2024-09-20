package com.面试中的算法.去哪儿.去哪儿9_6秋招;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 20:52
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] ans=in.nextLine().split(" ");
        Arrays.sort(ans,(s1, s2)->(s1+s2).compareTo(s2+s1));
        for (String s:ans){
            System.out.printf("%s ",s);
        }
    }
}

