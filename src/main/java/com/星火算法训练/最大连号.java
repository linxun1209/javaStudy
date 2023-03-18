package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/11/12 17:12
 */
public class 最大连号 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int[] result=new int[2];
        result[1]=1;
        for (int i=0;i<n-1;i++){
            result[0]=1;
            for (int j=i+1;j<n;j++){
                if(arr[j]==arr[j-1]+1){
                    result[0]++;
                }else {
                    break;
                }
            }
            if(result[0]>result[1]){
                result[1]=result[0];
            }

        }
        System.out.println(result[1]);

    }
}
