package com.面试中的算法.滴滴;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/7 17:32
 */
public class Main2 {
    static Map<String,Integer> map=new HashMap<>();//定义了一个静态的HashMap来存储已经计算过的结果，以避免重复计算。
    static  int[][] ans;//静态的二维数组ans来存储成本矩阵
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入 n 和 k
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n<2) {
            System.out.println(0);
            return;
        }

        // 输入 k*k 的成本矩阵
        int[][] cost = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        // 输入字符串
        String s = sc.next();
        ans=cost;
        char[] charArray = s.toCharArray();
        int res=getMaxCost(charArray,0,n-1);
        System.out.println(res);

    }

    private static int getMaxCost(char[] charArray, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        String key = stringBuilder.append(start).append("-").append(end).toString();
        //如果该键已经存在于HashMap中，说明之前已经计算过该子串的最大成本
        if (map.containsKey(key)) {
            return map.get(key);
        }
        //如果子串的起始位置大于等于结束位置，说明当前子串为空，所以返回0
        if (start >= end) {
            return 0;
        }
        //我们判断如果起始位置和结束位置相差为1，说明当前子串只有两个字符，所以直接调用getCost函数返回该字符对应的成本。
        if (end - start == 1) {
            return getCost(charArray[start],charArray[end]);
        }
        //递归调用getMaxCost函数分别计算左子串和右子串的最大成本，并将这两部分的成本累加起来，再加上将起始位置字符和分割点字符进行配对时的成本。
        int res = 0;
        for (int i = start+1; i <=end; i+=2) {
            res = Math.max(res, getCost(charArray[start], charArray[i]) + getMaxCost(charArray,start+1,i-1) + getMaxCost(charArray,i+1,end));
        }
        //将计算得到的最大成本存入HashMap中，并返回该最大成本。
        map.put(key,res);
        return res;
    }

    private static int getCost(int start, int end){
        int a=start-'a';
        int b=end-'a';
        return ans[a][b];
    }
}

