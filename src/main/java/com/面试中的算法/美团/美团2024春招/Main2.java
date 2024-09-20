package com.面试中的算法.美团.美团2024春招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 12:55
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long q=sc.nextInt();
        long[] arr=new long[(int) n];
        for (long i = 0; i < n; i++) {
            arr[(int)i]=sc.nextInt();
        }
        long sum=0;
        long res=0;
        for (long i = 0; i < n; i++) {
            if(arr[(int)i]!=0){
                sum+=arr[(int)i];
            }else {
                res++;
            }

        }
        long[][] qArr=new long[(int)q][2];
        for (long i = 0; i < q; i++) {
            qArr[(int)i][0]=sc.nextInt();
            qArr[(int)i][1]=sc.nextInt();
        }

        for (long i = 0; i < q; i++) {
            System.out.println((sum+res*qArr[(int)i][0])+" "+(res*qArr[(int)i][1]+sum));
        }


    }
}

