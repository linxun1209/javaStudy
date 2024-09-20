package com.面试中的算法.滴滴;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/7 17:46
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res=create(n,m);
        printResult(res);
    }
    private static void printResult(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }

    }

    private static int[] create(int n, int m) {
        int[] arr=new int[n];
        int base=n/m;
        int remainder=n%m;
        for (int i = 0; i < remainder; i++) {
            arr[i] =base+1;
        }
        for (int i = remainder; i < n; i++) {
            arr[i]=base;
        }
        return arr;
    }


}

