package com.面试中的算法.去哪儿.去哪儿9_6秋招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 20:55
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        String s=in.next();
        int maxK=-1;
        for (int i = 1; i <=n ; i++) {
            if(n%i==0){
                String sub=s.substring(0,i);
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < n/i; j++) {
                    sb.append(sub);
                }
                if(sb.toString().equals(s)){
                    maxK=Math.max(maxK,n/i);

                }
            }
            System.out.println(maxK);
        }
    }
}

