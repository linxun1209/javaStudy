package com.面试中的算法.美团8_31第一次笔试;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/31 19:39
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int q=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int l=in.nextInt();
            int r=in.nextInt();
            int Max_lr=Integer.MAX_VALUE;
            int Min_lr=Integer.MAX_VALUE;
            for (int j = l; j < r; j++) {
                if(a[j]>Max_lr){
                    Max_lr=a[j];
                }
                if(a[j]<Min_lr){
                    Min_lr=a[j];
                }
            }
            int Max_LR=Integer.MAX_VALUE;
            int Min_LR=Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
               if(a[j]>Max_LR){
                   Max_LR=a[j];
               }
               if(a[j]<Min_LR){
                   Min_LR=a[j];
               }
            }
            if(Max_lr>Max_LR){
                System.out.println("win");
            }else if(Max_LR==Max_lr){
                System.out.println("draw");
            }else {
                System.out.println("lose");
            }

        }
    }
}

