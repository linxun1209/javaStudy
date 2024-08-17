package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/17 19:26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();//组数
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < T; i++) {
            int n=in.nextInt();//代表给定的数字
            int m=findResult(n);//
            System.out.println(m);
        }
      

    }


    private static int gcd(int n,int m){
        while (m!=0){
            int temp=m;
            m=n%m;
            n=temp;
        }
        return n;
    }

    //得到一个数所有的公约数
    private static List<Integer> getGCD(int n){
        List<Integer> ans=new ArrayList<>();
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i==0){
                ans.add(i);
                if(i!=Math.sqrt(n)){
                    ans.add(n/i);
                }
            }
        }
        return ans;
    }

    private static int findResult(int n) {

        List<Integer> gcd = getGCD(n);
        int[] result=new int[gcd.size()];
        for (int i = 0; i < gcd.size(); i++) {
            result[i]=gcd.get(i);
        }
        Arrays.sort(result);
        //得到一个数是公约数
        for (int i = result.length-1; i >0; i--) {
            if(isSushu(gcd.get(i))){
                return gcd.get(i);
            }
        }
        return -1;
    }


    /**
     * 判断是不是素数
     * @param n
     * @return
     */

    private static boolean isSushu(int n) {
        if(n<=1){
            return false;
        }
        if(n<=2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for (int i = 3; i < Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
        
    }

}

