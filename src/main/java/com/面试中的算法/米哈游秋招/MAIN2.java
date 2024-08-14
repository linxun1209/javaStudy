package com.面试中的算法.米哈游秋招;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 *
 * 商店里有 n个商品，分别编号为 1~n ，每个商品都有一个价值 vali和体积 wi，米小游有一个有一个 m 容量的背包，
 * 他能够装得下任意多个体积之和不超过 m 的商品。
 *
 * 米小游认为有些东西一起购买会带来灾难，比如可莉的角色立牌和蹦蹦炸弹的小手办，所以他设定了 k组互斥关系，
 * 每组关系给定两个数字 a,b，表示编号为 a 的商品和编号为 b的商品不能同时购买。
 *
 * 米小游希望装下的物品的价值之和最大，请你帮帮他求出最大价值。
 *
 * 输入描述
 *
 * 第一行输入三个整数 n,m,k(1<=n<=15;1<=m<=10^9;0<=k<=15)表示商品数量、背包容量和互斥关系数量。
 *
 * 接下来 n行，每行输入两个整数 wi,vali(1<=wi,vali<=10^9) 表示每个物品的体积和价值。
 *
 * 接下来 k行，每行输入两个整数 a,b(1<=a,b<=n,a≠b)，描述一组互斥关系。
 *
 * 输出描述
 *
 * 在一行上输出一个整数表示答案。
 * @date 2024/8/3 20:52
 */
public class MAIN2 {



    private static int n,m,k;
    private static int[][] arr;
    private static Set<Integer>[] ans;
    private static int res=0;

    private static boolean check(int i,Set<Integer> les){
        for(int a:les){
            if(ans[a].contains(i)){
                return false;
            }
        }return true;
    }



    private static void backend(int i,int currValue,int currWeight,Set<Integer> les){
        if(i>=n){
            res=Math.max(res,currValue);
            return;
        }
        backend(i+1,currValue,currWeight,les);
        //不是互斥关系且重量满足就可以计算该数据然后回溯重新计算，直到找到最大值
        if(check(i,les)&&currWeight+arr[i][0]<=m){
            les.add(i);
            backend(i+1,currValue+arr[i][0],currWeight+arr[i][0],les);
            les.remove(i);
        }
    }







    //对数据进行数据结构的选择，之后进行赋值

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         n= in.nextInt();
         m=in.nextInt();
         k=in.nextInt();
         arr=new int[n][2];
         ans=new HashSet[n];
         //商品的重量和价值的初始化
        for (int i = 0; i < n; i++) {
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ans[i]=new HashSet<>();
        }
        for (int i=0;i<k;i++){
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            ans[a].add(b);
            ans[b].add(a);
        }
        Set<Integer> les=new HashSet<>();
        backend(0,0,0,les);
        System.out.println(res);
        in.close();

//        int[] dp=new int[n+1];
//
//        //互斥表的序号为n的序号
//        //相当于给了一串商品，除去互斥关系之后，在剩下的商品中获得价值之和最大，且体积小于等于m
//        dp[0]=arr[0][1];//初始为第一个商品的价值
//        for (int j = 0; j < k; j++) {
//            for (int i = 0; i < n; i++) {
//                if(ans[j][0]==i&&ans[j][1]!=i+1) {
//                    dp[i + 1] = arr[i][1] + arr[i + 1][1];
//                }else if(ans[j][0]==i&&ans[j][1]==i+1){
//                    dp[i+1]=Math.max(dp[i+1],dp[i]);
//                }
//            }
//        }
//        System.out.println(2*dp[n-1]);
    }
}

