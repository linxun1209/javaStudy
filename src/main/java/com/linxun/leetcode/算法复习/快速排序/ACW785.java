package com.linxun.leetcode.算法复习.快速排序;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 *  给定你一个长度为 n 的整数数列。
 *  请你使用快速排序对这个数列按照从小到大进行排序。
 *  并将排好序的数列按顺序输出。
 * @date 2024/7/19 14:37
 */
public class ACW785 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n - 1);
        for(int i = 0; i < n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void quickSort(int[] q,int l ,int r){
        if(l >= r){
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = q[l + r >> 1];
        while(i < j){
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if(i < j){
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q,l,j);
        quickSort(q,j+1,r);
    }
}

