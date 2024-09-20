package com.面试中的算法.去哪儿.去哪儿9_6秋招;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 20:30
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        int[] res1=new int[n];
        String[] ans1=in.nextLine().split(" ");
        for (int i=0; i<n; i++) {
            res1[i]=Integer.parseInt(ans1[i]);
        }
        int[] res2=new int[n];
        String[] ans2=in.nextLine().split(" ");
        for (int i=0; i<n; i++) {
            res2[i]=Integer.parseInt(ans2[i]);
        }
        int l=0,r=n-1;
        while (l<=r){
            int mid=(r-l)/2+l;
            if(checkTrue(res1,res2,mid,m)){
                r=mid-1;
            }else {
                l=mid+1;
            }

        }
        System.out.println(l>=n?-1:(l+1));
    }
    public static boolean checkTrue(int[] res1,int[] res2,int mid,int m){
        int[] Ans1Copy= Arrays.copyOfRange(res1,0,mid+1);
        int[] Ans2Copy= Arrays.copyOfRange(res2,0,mid+1);
        Arrays.sort(Ans2Copy);
        long res=0l;
        for(int i=mid;i>=0;i--){
            res+=(long)Ans1Copy[i]*Ans2Copy[i];
            if(res>=m){
                return true;
            }

        }
        return false;
    }

}

