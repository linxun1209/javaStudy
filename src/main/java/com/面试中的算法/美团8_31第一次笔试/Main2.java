package com.面试中的算法.美团8_31第一次笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/31 19:29
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);
        int low=0;
        int height=arr[n-1]-arr[0];
        while (low<height){
            int mid=(low+height)/2;
            int count=0;
            int sum=0;
            for (int i = 1; i < n; i++) {
                if(arr[i]<=arr[i-1]+mid){
                    count=arr[i]-arr[i-1];
                }else {
                    count+=mid;
                }
            }
            sum=count+arr[n-1]-1;
            if(sum<k){
                low=mid+1;
            }else {
                height=mid;
            }
        }
        System.out.println();
    }
}

