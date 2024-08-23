package com.面试中的算法.b站.B站0821笔试;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/21 19:28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n=s.length();
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=i+1;
            for (int j=0;j<i;j++){
                if((i+1)%(i-j+1)==0){
                    boolean macth=true;
                    for (int k=j+1;k<=i;k++){
                        if(s.charAt(k)!=s.charAt(k-(i-j+1))){
                            macth=false;
                            break;

                        }
                        if(macth){
                            dp[i]=Math.min(dp[i],dp[j]+1);
                        }
                    }
                }
            }
        }
        System.out.println(dp[n-1]);
    }

}

