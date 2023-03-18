package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/11/16 10:23
 */
public class 小玉的电费 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        double m=0;
        if(n<=150){
            m=0.4463*n;
        }else if(n>151&&n<=400){
            m=0.4663*(n-150)+0.4463*150;
        }else{
            m+=0.5664*(n-400)+0.4663*250+0.4463*150;
        }
        System.out.println(String.format("%.1f",m-0.05));
        System.out.println(m);

    }
}
