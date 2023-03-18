package com.星火算法训练;

import java.util.Scanner;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/11/16 10:56
 */
public class 车站 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt(),n=scanner.nextInt(),m=scanner.nextInt(),x=scanner.nextInt();
        int k=0;
        int[] up=new int[21];
        int[] ans=new int[21];
        int[] ss=new int[21];
        while (true){
            up[0]=a;
            up[1]=k;
            ans[0]=a;
            ans[1]=a;
            k++;
            for (int i = 2; i < n; i++) {
                up[i]=up[i-1]+up[i-2];
                ss[i]=up[i-1];
                ans[i]=ans[i-1]+up[i]-ss[i];

            }
            if(ans[n-1]==m){
                System.out.println(ans[x]);
                return;
            }
        }
    }
}
