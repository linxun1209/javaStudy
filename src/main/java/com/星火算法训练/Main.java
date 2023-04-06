package com.星火算法训练;


import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        String[] ans=new String[10];
        for(int i=0;i<n;i++) {
            a[i]=scanner.nextInt();
            if(a[i]=='1')
            {

                ans[1]+="..X.";
                ans[2]+="..X.";
                ans[3]+="..X.";
                ans[4]+="..X.";
                ans[5]+="..X.";
            }
            if(a[i]=='2')
            {
                ans[1]+="XXX.";
                ans[2]+="..X.";
                ans[3]+="XXX.";
                ans[4]+="X...";
                ans[5]+="XXX.";
            }
            if(a[i]=='3')
            {
                ans[1]+="XXX.";
                ans[2]+="..X.";
                ans[3]+="XXX.";
                ans[4]+="..X.";
                ans[5]+="XXX.";
            }
            if(a[i]=='4')
            {
                ans[1]+="X.X.";
                ans[2]+="X.X.";
                ans[3]+="XXX.";
                ans[4]+="..X.";
                ans[5]+="..X.";
            }
            if(a[i]=='5')
            {
                ans[1]+="XXX.";
                ans[2]+="X...";
                ans[3]+="XXX.";
                ans[4]+="..X.";
                ans[5]+="XXX.";
            }
            if(a[i]=='6')
            {
                ans[1]+="XXX.";
                ans[2]+="X...";
                ans[3]+="XXX.";
                ans[4]+="X.X.";
                ans[5]+="XXX.";
            }
            if(a[i]=='7')
            {
                ans[1]+="XXX.";
                ans[2]+="..X.";
                ans[3]+="..X.";
                ans[4]+="..X.";
                ans[5]+="..X.";
            }
            if(a[i]=='8')
            {
                ans[1]+="XXX.";
                ans[2]+="X.X.";
                ans[3]+="XXX.";
                ans[4]+="X.X.";
                ans[5]+="XXX.";
            }
            if(a[i]=='9')
            {
                ans[1]+="XXX.";
                ans[2]+="X.X.";
                ans[3]+="XXX.";
                ans[4]+="..X.";
                ans[5]+="XXX.";
            }
            if(a[i]=='0')
            {
                ans[1]+="XXX.";
                ans[2]+="X.X.";
                ans[3]+="X.X.";
                ans[4]+="X.X.";
                ans[5]+="XXX.";
            }

        }
        for(int i=0;i<5;i++){
            ans[i]=ans[i].substring(0,ans[i].length()-1);
            System.out.println(ans[i]);
        }

    }
}
