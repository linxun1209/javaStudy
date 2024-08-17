package com;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/17 19:35
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        int currentSum=0;
        for (int i=0;i<nums.length;i++){
            currentSum+=nums[i];
        }
        int minCurrentSum=currentSum;
        for (int i = 0; i < n; i++) {
            int sum=0;
            for(int j=i;i<=n;j++){
               sum+=nums[j];
               int newSum=currentSum-sum+sum*n;
            }
        }
    }
}

