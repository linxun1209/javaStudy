package com.linxun.leetcode.算法复习.快速排序;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 *给定一个长度为 ” 的整数数列，以及一个整数k，
 * 请用快速选择算法求出数列从小到大排序后的第k个数。
 * 输入格式
 * 第一行包含两个整数 n 和 k。
 * 第二行包含 几 个整数(所有整数均在1~ 10°范围内)，表示整数数列。输出格式
 * 输出一个整数，表示数列的第 k小数。
 * @date 2024/7/19 14:51
 */
public class ACW786 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n < k){
            return;
        }
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        quickSort(nums,0,n - 1);

        System.out.print(nums[k - 1]);

    }
    public static void quickSort(int[] q,int l , int r){
        if(l >= r){
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = q[l + r >>1];
        while(i < j){
            do i++; while(q[i] < x);
            do j--;while(q[j] > x);
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

