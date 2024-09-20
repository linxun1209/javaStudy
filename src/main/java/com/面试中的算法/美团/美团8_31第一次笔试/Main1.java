package com.面试中的算法.美团.美团8_31第一次笔试;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/31 19:20
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] words=s.split(" ");
        int count=0;
        for(String word:words){
            if(word.length()!=0&&word!=null&&Character.isUpperCase(word.charAt(0))){
                count++;
            }
        }
        System.out.println(count);
    }
}

