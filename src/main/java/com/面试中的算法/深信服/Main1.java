package com.面试中的算法.深信服;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 19:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String color=in.nextLine();
        String s=in.nextLine();
        int ans=0;
        int i=0,j=0;
        while(i<color.length()&&j<s.length()){
            if(color.charAt(i)==s.charAt(j)){
                ans++;
                i++;
                j++;
            }else if(s.charAt(j)=='*'){
                if(j>0&color.charAt(i)==s.charAt(j-1)){
                    ans++;
                    i++;
                }else {
                    j++;
                    continue;
                }
            }else {
                break;
            }
        }
//        for (int i = 0; i < color.length(); i++) {
//            if(color.charAt(i)!=s.charAt(i)&&s.charAt(i)!='*'){
//                break;
//            }else if(color.charAt(i)==s.charAt(i)){
//                ans++;
//                continue;
//            }else if(s.charAt(i)=='*'){
//                //此时为*
//                if(i>0&&color.charAt(i)==s.charAt(i-1)){
//                    ans++;
//                }
//            }
//        }
        System.out.println(ans);

    }
}

