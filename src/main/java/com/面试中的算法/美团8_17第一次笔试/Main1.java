package com.面试中的算法.美团8_17第一次笔试;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 * 小美对 (最大公约数) 很感兴趣, 她会询问你次。每次询问给出一个大于  的正整数 , 你是否找到一个数字，使得  为素数.
 *
 * 输入描述
 * 每个测试文件将包含多组测试数据,每组测试数据的第一行包含一个整数 , 表示有 个待测数字.接下来  行,每行包含一个整数,表示待测的数字.
 *
 * 输出描述
 * 对于每一组测试数据, 在一行上输出一个整数，代表数字 。如果有多种合法答案，您可以输出任意一种。
 * @date 2024/8/17 22:10
 *
 *
 */
public class Main1 {


    /**
     * 对于m来说如果该数字本身为素数则直接输出就可以，如果本身不是素数，则在素数中找到一个可以除尽的数字便可以啦
     * 从第一个质数2开始遍历，直到遍历到n的平方根，如果n能被这个质数整除
     * 那么这个质数就是n的一个因子，输出这个质数即可。
     * 此时输出的这个质数也就是素数即为对应的m
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        while (k-->0){
            int n=scanner.nextInt();
            boolean isPrime=true;
            for (int i=2;i<=Math.sqrt(n);i++){
                if(k%i==0){
                    System.out.println(i);
                    isPrime=false;
                    break;
                }
            }
            if(isPrime=true){
                System.out.println(n);
            }
        }
    }

}

