package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/22 14:42
 */
public class bestTeamScore {
    public static void main(String[] args) {
        int[] score={1,2,3,5};
        int[] ages={8,9,10,1};
        bestTeamScore(score,ages);
    }


    public static int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] combine = new int[len][2];
        for(int i = 0; i < len; i++){
            combine[i][0] = ages[i];
            combine[i][1] = scores[i];
        }

        Arrays.sort(combine, (o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        int[] dp = new int[len];
        int ans = 0;
        for(int i = 0; i < len; i++){
            dp[i] = combine[i][1];
            for(int j = 0; j < i; j++){
                if(combine[j][1] <= combine[i][1]){
                    dp[i] = Math.max(dp[i], combine[i][1] + dp[j]);
                }
            }
        }

        for(int i = 0; i < len; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
