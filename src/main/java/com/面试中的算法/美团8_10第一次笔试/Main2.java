package com.面试中的算法.美团8_10第一次笔试;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/17 18:37
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-->0){
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long x = scanner.nextLong();
            long[] a=new long[(int)n];
            for (int i = 0; i < n; i++) {
                a[i]=scanner.nextLong();
            }
            long[] dp=new long[(int)n+1];
            Arrays.fill(dp,Long.MAX_VALUE);
            long suffix_MEX=0;
            dp[(int)n]=0;
            Set<Long> vst=new HashSet<>();
            for (int i=(int)(n-1);i>=0;--i){
                vst.add(a[i]);
                while (vst.contains(suffix_MEX)){
                    suffix_MEX++;
                }
                dp[i]= Math.min(dp[i+1]+x,k*suffix_MEX);
            }
            System.out.println(dp[0]);
        }

        scanner.close();

    }
}

