package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/20 18:34
 */
public class minCount {
    public static void main(String[] args) {
        int[] c={2,3,10};
        minCount(c);
    }
    public static int minCount(int[] coins) {
        int min=0;
        for (int m:coins){
            min+=m/2;
            if(m%2==1){
                min+=1;
            }
        }
        return min;


    }
}
