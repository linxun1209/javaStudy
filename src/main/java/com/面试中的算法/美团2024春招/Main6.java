package com.面试中的算法.美团2024春招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 14:37
 */
public class Main6{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt(), k = in.nextInt();
            int[] a = new int[n];
            for(int i = 0;i < n;i++){
                a[i] = in.nextInt();
            }
            int[] countBy2 = new int[n], countBy5 = new int[n];
            for(int i = 0;i < n;i++){
                while(a[i] % 2 == 0){
                    a[i] /= 2;
                    countBy2[i]++;
                }
                while(a[i] % 5 == 0){
                    a[i] /= 5;
                    countBy5[i]++;
                }
            }
            int totalBy2 = 0, totalBy5 = 0;
            for(int i = 0;i < n;i++){
                totalBy2 += countBy2[i];
                totalBy5 += countBy5[i];
            }
            long res = 0;
            for(int i = 0, j = 0;j < n;j++){
                totalBy2 -= countBy2[j];
                totalBy5 -= countBy5[j];
                while(i <= j && Math.min(totalBy2, totalBy5) < k){
                    totalBy2 += countBy2[i];
                    totalBy5 += countBy5[i];
                    i++;
                }
                res += j - i + 1;
            }
            System.out.println(res);
        }
    }

}

