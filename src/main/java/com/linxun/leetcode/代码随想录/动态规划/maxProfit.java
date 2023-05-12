package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/11 12:35
 */
public class maxProfit {
    public int maxProfit(int prices[]) {
        int min=Integer.MAX_VALUE;
        int ans=0;
        for (int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else if(prices[i]-min>ans){
                ans=prices[i]-min;
            }
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int[] dp = new int[2];
        // 0表示持有，1表示卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }
}
