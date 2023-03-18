package com.linxun.leetcode.每日挑战;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/15 20:59
 */
public class maximalNetworkRank {
    public static void main(String[] args) {
        int[][] roads={{0,1},{0,3},{1,2},{1,3}};
        int[] cnt = new int[5];
        int ans = 0;
        int[][] connect = new int[5][5];
        for (int[] road:roads){
            cnt[road[0]]++;
            cnt[road[1]]++;
            connect[road[0]][road[1]] = 1;
            connect[road[1]][road[0]] = 1;
            System.out.println(Arrays.toString(cnt));
        }
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                ans = Math.max(ans, cnt[i] + cnt[j] - connect[i][j]);
            }
        }
        System.out.println(ans);


    }
}
