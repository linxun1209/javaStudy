package com.linxun.leetcode.每日挑战;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/15 21:16
 */
public class giveGem {
    public static void main(String[] args) {
        int[] gem = {3,1,2};
        int[][] operations = {{0,2},{2,1},{2,0}};
        giveGem(gem,operations);
    }

    public static int giveGem(int[] gem, int[][] operations) {
        int m=operations.length;
        int n=operations[0].length;
        for (int i=0;i<m;i++){
            int one=operations[i][0];
            int two=operations[i][1];
                int t=gem[one]/2;
                gem[one]-=t;
                gem[two]+=t;

        }
        Arrays.sort(gem);
        return gem[gem.length-1]-gem[0];

    }
}
