package com.面试中的算法.美团.美团2024春招;

import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 小美拿到了一个
 * n
 * ∗
 * n
 * n∗n的矩阵，其中每个元素是 0 或者 1。
 * 小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
 * 现在，小美希望你回答有多少个
 * i
 * ∗
 * i
 * i∗i的完美矩形区域。你需要回答
 * 1
 * ≤
 * i
 * ≤
 * n
 * 1≤i≤n的所有答案。
 * @date 2024/8/18 11:59
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] rect = new String[n];
        for (int i = 0; i < n; i++) {
            rect[i]=in.nextLine();
        }
        //为了便于理解转化为二维数组
        int[][] rectInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rectInt[i][j]=rect[i].charAt(j)-'0';
            }
        }
        // 使用 二维 数组的前缀和  之所以 +1 是为了统一 操作, 避免判断边界
        //如果 不用 n+1 而使用 n  则需要手动初始化 第一行和第一列
        //https://www.bilibili.com/video/BV1c64y1p7Z1/?spm_id_from=333.337.search-card.all.click&vd_source=deb80297a2c89a7c09425884c13200ac  参考视频
        int[][] preSum = new int[n + 1][n + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                preSum[i][j]=preSum[i][j-1]+preSum[i-1][j]-preSum[i-1][j-1]+rectInt[i-1][j-1];
                //直接访问字符串更快一点
                //preSum[i][j]=preSum[i][j-1]+preSum[i-1][j]-preSum[i-1][j-1]+(rect[i-1].charAt(j-1)-'0');
            }
        }
        for (int k = 1; k <= n; k++) {  //控制矩形大小
            if (k%2!=0){  // 奇数个元素 0 和 1 的数量不可能相等
                System.out.println(0);
                continue;
            }
            int res=0;
            int target=(k*k)/2;
            for (int i = k; i <=n ; i++) {
                for (int j = k; j <=n; j++) {
                    //计算每一个小正方形的和
                    int sum=preSum[i][j]-preSum[i-k][j]-preSum[i][j-k]+preSum[i-k][j-k];
                    if (sum==target){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

}

