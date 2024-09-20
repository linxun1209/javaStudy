package com.面试中的算法.美团.美团8_31第一次笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/31 20:18
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int low=0;
        int height=arr[n-1]-arr[0];
        while (low<height) {
            int mid = (low + height) / 2;
            if(check(arr,mid,k)){
                low=mid+1;
            }else {
                height=mid;
            }
        }
        System.out.println(low);
    }

    private static boolean check(int[] arr, int mid, int k) {
        int plant=1;
        int pre=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-pre>mid){
                plant+=arr[i]-pre;
                pre=arr[i];
            }
        }
        return plant>=k;
    }
}

