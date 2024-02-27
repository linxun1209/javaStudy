package com.linxun.leetcode.hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/21 18:31
 */
public class maxProfit {

    /**
     * 只能买卖一次的情况
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices.length<1){
            return 0;
        }
        int min=prices[0],max=0;
        for (int i=1;i<prices.length;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }


    /**
     * 单调栈
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int res = 0;
        int n = prices.length;
        LinkedList<Integer> stack = new LinkedList<>();

        // 单调栈
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek() >= prices[i]) {
                stack.push(prices[i]);
            } else {
                res = prices[i] - stack.peek() >= res ? prices[i] - stack.peek() : res;
            }
        }

        return res;
    }


    /**
     * 快慢指针
     * @param prices
     * @return
     */
    public int MaxProfit4(int[] prices) {
        int maxMoney = 0;//最大利润
        int slowIndex = 0;//慢指针
        int fastIndex = 1;//快指针
        int lastIndex = prices.length - 1;//最后索引
        while(fastIndex <= lastIndex){
            int money = prices[fastIndex] - prices[slowIndex];
            if(money > maxMoney){
                maxMoney = money;
            }
            if(money<0){
                slowIndex = fastIndex;
            }
            fastIndex++;
        }
        return maxMoney;
    }

    /**
     * 可以买卖多次的情况
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
