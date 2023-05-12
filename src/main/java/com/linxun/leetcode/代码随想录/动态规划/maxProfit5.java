package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/12 21:40
 */
public class maxProfit5 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //由于可以无限次交易，所以只定义两个维度，
        //第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有，2表示过渡期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天不持有股票的情况有两种
            //a.第i-1天也不持有股票
            //b.第i-1天是过渡期
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            //第i天持有股票有两种情况
            //a.第i-1天也持有股票，第i天不操作，
            //b.第i-1天不持有股票，在第i天买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            //第i天是冷冻期只有一种情况，第i-1天持有股票且卖出
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        //最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);
    }

    public int maxProfit2(int[] prices) {
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


    public int maxProfit3(int[] prices) {
        int[] dp=new int[4];

        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 使用临时变量来保存dp[0], dp[2]
            // 因为马上dp[0]和dp[2]的数据都会变
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i-1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i-1];
            dp[3] = temp1;
        }
        return Math.max(dp[3],Math.max(dp[1],dp[2]));
    }

    public int maxProfit4(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = -prices[0];

        for (int i = 2; i <= prices.length; i++) {
            /*
            dp[i][0] 第i天持有股票收益;
            dp[i][1] 第i天不持有股票收益;
            情况一：第i天是冷静期，不能以dp[i-1][1]购买股票,所以以dp[i - 2][1]买股票，没问题
            情况二：第i天不是冷静期，理论上应该以dp[i-1][1]购买股票，但是第i天不是冷静期说明，第i-1天没有卖出股票，
                则dp[i-1][1]=dp[i-2][1],所以可以用dp[i-2][1]买股票，没问题
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
        }
        return dp[prices.length][1];
    }
}
