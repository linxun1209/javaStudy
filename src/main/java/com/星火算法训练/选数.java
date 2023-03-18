package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/12/7 20:41
 */
public class 选数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),k=scanner.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }
        int dnf = dnf(0, 0, n, k, 0, arr);
        System.out.println(dnf);
    }
    static int dnf(int m,int sum,int n,int k,int start,int[] a){
        int ans=0;
        if(m==k){
            if(ispirme(sum)){
                ans++;
            }
        }
        for (int i = start; i < n; i++) {
            ans+=dnf(m+1,sum+a[i],n,k,i+1,a);

        }
        return ans;
    }


    static boolean ispirme(int a){
        for (int i = 2; i*i<=a; i++) {
            if(a%i==0){
                return false;
            }
        }
            return true;
    }
}
