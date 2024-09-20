package com.面试中的算法.去哪儿.去哪儿2023春招;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 18:49
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] a=scanner.nextLine().split(" ");
        int n=Integer.parseInt(a[0]);
        int m=Integer.parseInt(a[1]);
        int[] ans=new int[n];
        String[] as=scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            ans[i]=Integer.parseInt(as[i]);
        }
        int[] ans2=new int[n];
        String[] as2=scanner.nextLine().split(" ");
        for (int i = 0; i < n-m; i++) {
            ans2[i]=Integer.parseInt(as2[i]);
        }
        int l=0,r=n-1;
        while (l<=r){
            int mid=(r-l)/2+l;
            if(checkTrue(mid,ans,ans2,m)){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        System.out.println(l>=n?-1:l+1);
    }

    private static boolean checkTrue(int mid, int[] ans, int[] ans2, int m) {
        int[] copyAns1= Arrays.copyOfRange(ans,0,mid+1);
        int[] copyAns2= Arrays.copyOfRange(ans2,0,mid+1);
        Arrays.sort(copyAns2);
        long res=0l;
        for (int i=mid;i>0;i--){
            res+=(long)copyAns1[i]*copyAns2[i];
            if(res>=m){
                return true;
            }
        }
        return false;
    }
}

