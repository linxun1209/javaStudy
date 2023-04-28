package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/4/28 8:54
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=1;i<=prices.length-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // [天数][是否持有股票]
        int[][] dp = new int[prices.length][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
