package com.星火算法训练;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/10/16 18:14
 */
import java.util.Scanner;
public class 过河卒 {
    static long[][] a;
    //存储不能走的位置

    static long[][] b;
    //存储每一格能够到达的走法有多少种

    static int d,e;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt(),n = scanner.nextInt();
        a = new long[g + 4][n + 4];
        //将数组开大一点，不用对马能跳到位置进行判断
        b = new long[g + 4][n + 4];
        d = scanner.nextInt();
        e = scanner.nextInt();
        mt(d + 2,e + 2);
        b[2][1] = 1;
        //初始化第一个格子
        for (int i = 2; i <= g + 2; i++) {
            for (int j = 2; j <= n + 2; j++) {
                if (a[i][j] != -1){
                    b[i][j] += b[i - 1][j] + b[i][j - 1];
                }
            }
        }//每个格子只能从左边或者上面走到这个格子，所以只需要将这两个格子的走法相加就可以了
//a[i][j] != -1判断这个格子能不能走
        System.out.println(b[g + 2][n + 2]);
    }
    public static void mt(int j,int m){
        a[j][m] = -1;
        a[j - 2][m + 1] = -1;
        a[j - 1][m + 2] = -1;
        a[j - 2][m - 1] = -1;
        a[j - 1][m - 2] = -1;
        a[j + 2][m + 1] = -1;
        a[j + 1][m + 2] = -1;
        a[j + 2][m - 1] = -1;
        a[j + 1][m - 2] = -1;
    }//根据马的位置将马不能跳到位置标出
}