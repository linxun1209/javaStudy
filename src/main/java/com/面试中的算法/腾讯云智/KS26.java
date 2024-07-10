package com.面试中的算法.腾讯云智;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 给定两个字符串，已知可以使用三种方式进行变换
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 更改一个字符
 * 请设计一个算法，找到两个字符串之间的经历几次最小变换，可以字符串1转换成字符串2
 *
 * 数据范围：输入字符串的长度满足
 * 1
 * ≤
 * 𝑛
 * ≤
 * 1000
 *
 * 1≤n≤1000
 * 输入描述：
 * 输入两个字符串
 * 输出描述：
 * 最小变换次数
 * @date 2024/6/13 8:27
 */


public class KS26 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String nextedLine = scanner.nextLine();
        char[] chars=s.toCharArray();
        char[] chars1=nextedLine.toCharArray();
        int[][] result=new int[chars.length][chars1.length];
        for (int i=0;i<chars.length;i++){
            result[i][0]=i;
        }
        for (int i=0;i<chars1.length;i++){
            result[0][i]=i;
        }
        for (int i=1;i<chars.length;i++){
            for (int j=1;j<chars1.length;j++){
                if(chars[i-1]==chars1[j-1]){
                    result[i][j]=result[i-1][j-1];
                }else {
                    result[i][j]=Math.min(result[i-1][j-1],Math.min(result[i-1][j],result[i][j-1])+1);
                }
            }
        }
        System.out.println(result[chars.length-1][chars1.length-1]);


    }
}

