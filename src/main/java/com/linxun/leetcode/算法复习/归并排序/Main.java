package com.linxun.leetcode.算法复习.归并排序;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 归并排序算法
 * @date 2024/7/19 15:11
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n;i++){
            nums[i] =sc.nextInt();
        }
        merageSort(nums,0,n-1);
        for(int i = 0; i < n;i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void merageSort(int[] q,int l, int r){
        if(l >= r){
            return;
        }
        int mid = l + r >> 1;
        merageSort(q,l,mid);
        merageSort(q,mid+1,r);
        int[] temp = new int[r - l + 1];
        int k = 0,i = l, j = mid + 1;
        while(i <= mid && j <= r){
            if(q[i] <= q[j]){
                temp[k++] = q[i++];
            }else{
                temp[k++] =q[j++];
            }
        }
        while(i <= mid){
            temp[k++] = q[i++];
        }
        while(j <=r){
            temp[k++] = q[j++];
        }
        for( i = l , j = 0;i <= r;i++,j++){
            q[i] = temp[j];
        }
    }
}

