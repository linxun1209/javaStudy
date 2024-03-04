package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 121. 买卖股票的最佳时机
 * @date 2024/3/4 10:34
 */
public class maxProfit {

    //直接转换成最大值减去最小值==最大利润   但是最大值要出现在最小值后面 那就动态的寻找最小值和最大值并进行赋值

    public int maxProfit(int[] prices) {
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

    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


}

