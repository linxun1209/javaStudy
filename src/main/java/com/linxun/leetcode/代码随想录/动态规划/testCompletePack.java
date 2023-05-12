package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/9 17:16
 */
public class testCompletePack {
    //先遍历物品，再遍历背包
    private static void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){ // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++){ // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){ // 遍历背包容量
            for (int j = 0; j < weight.length; j++){ // 遍历物品
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }
}
