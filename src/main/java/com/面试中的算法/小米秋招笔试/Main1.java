package com.面试中的算法.小米秋招笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/19 16:45
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int n = scanner.nextInt();
            int c=scanner.nextInt();
            int[] arr = new int[n];
            //每个玩具的容量
            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();
            Arrays.sort(arr);
            boolean[] flag=new boolean[N+1];
            flag[0]=true;
            int sum=0;
            for (int i = 0; i < n; i++) {
                for (int j = N; j >=arr[i] ; j--) {
                    sum+=arr[i];
                    if(sum<N) {
                        break;
                    }else if(sum==N){
                        flag[j]=true;
                        break;
                    }else {
                        if(sum-arr[i]+c==N){
                            flag[j]=true;
                            break;
                        }else {
                            flag[j]=flag[j]||flag[j-arr[i]];
                            break;
                        }

                    }

                }
            }
            if(flag[N]){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }


    }
}

