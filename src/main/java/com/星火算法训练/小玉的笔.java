package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/11/16 10:17
 */
public class 小玉的笔 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int count=n*10+m;
        int arr=19;
        int r=count/arr;
        System.out.println(r);
    }
}
