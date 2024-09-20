package com.面试中的算法.去哪儿.去哪儿9_6秋招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 19:58
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] res=new long[n];
        for (int i = 0; i < n; i++) {
            res[i]=in.nextInt();
        }
        int ans2 = in.nextInt();
//        Arrays.sort(res,new Comparator<Long>(){
//            @Override
//            public int compare(long o1, long o2) {
//                String a1=o1.toString()+o2.toString();
//                String a2=o2.toString()+o1.toString();
//                return a2.compareTo(a1);
//            }
//        });
//        System.out.println(f);

//        String[] ans=in.nextLine().split(" ");
//        Arrays.sort(ans,(s1,s2)->(s1+s2).compareTo(s2+s1));
//        long res=0;
//        for (String s:ans){
//            res=Math.max(res,Integer.parseInt(s));
//        }
//        System.out.println(res);
    }
}

