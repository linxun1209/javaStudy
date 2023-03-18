package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/10/17 20:45
 */
public class 子数整数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int m=0;
        for(int i=10000;i<=30000;i++){
            if(i/100%k==0){
                if((i/10-i/10000*1000)%k==0){
                    if((i-i/1000*1000)%k==0){
                        System.out.println(i);
                        m++;
                    }
                }
            }
        }
        System.out.println(m);
        if(m==0){
            System.out.println("N0");
        }


    }

}
