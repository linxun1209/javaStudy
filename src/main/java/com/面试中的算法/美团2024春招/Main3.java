package com.面试中的算法.美团2024春招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 13:15
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String arr=sc.next();
        int ans=0;
        for (int i = 0; i < arr.length(); i++) {
            if(arr.charAt(i)!='T'&&arr.charAt(i)!='M'){
                ans++;
            }
        }
        System.out.println(ans+"dsdddd");
        if(ans==k){
            System.out.println(n);
        }else if (ans>k){
            System.out.println(n-ans+k);
        }else {
            System.out.println(n);
        }
    }

}

