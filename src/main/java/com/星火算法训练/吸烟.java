package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/10/17 20:22
 */
public class 吸烟 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int a=0;
        int b=0;
        while (n!=0){
            n--;
            a++;
            if(a==k){
                n++;
                a=0;
            }
            b++;

        }
        System.out.println(b);

    }
}
