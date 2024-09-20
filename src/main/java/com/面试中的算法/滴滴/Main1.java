package com.面试中的算法.滴滴;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/7 17:27
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            if(n==1){
                System.out.println(0);
            }else if(n==2){
                System.out.println(2);
            }else {
                System.out.println(2*m);
            }
        }

//        for (int i = 0; i < T; i++) {
//           create(sc.nextLong(),sc.nextLong());
//        }
    }


//    private static long create(long n, long m) {
//        long[] arr=new long[(int)n];
//        long base=n/m;
//        if(base==1){
//            return m;
//        }
//        long remainder=n%m;
//        for (long i = 0; i < remainder; i++) {
//            arr[(int)i] =base+1;
//        }
//
//        int res=0;
//        for (long i = remainder; i < n; i++) {
//            arr[(int)i]=base;
//        }
//        return res;
//    }
}

