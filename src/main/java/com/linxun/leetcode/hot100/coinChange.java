package com.linxun.leetcode.hot100;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/22 12:50
 */
public class coinChange {

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) {
            return -1;
        }

        //声明一个amount+1长度的数组dp，代表各个价值的钱包，第0个钱包可以容纳的总价值为0，其它全部初始化为无穷大
        //dp[j]代表当钱包的总价值为j时，所需要的最少硬币的个数
        int[] dp = new int[amount+1];
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);

        //i代表可以使用的硬币索引，i=2代表只在第0个，第1个，第2个这三个硬币中选择硬币
        for (int i = 0; i < coins.length; i++) {
            /**
             * 	当外层循环执行一次以后，说明在只使用前i-1个硬币的情况下，各个钱包的最少硬币个数已经得到，
             *  有些钱包的值还是无穷大，说明在仅使用前i-1个硬币的情况下，不能凑出钱包的价值
             * 	现在开始再放入第i个硬币，要想放如w[i]，钱包的价值必须满足j>=w[i]，所以在开始放入第i个硬币时，j从w[i]开始
             */
            for (int j = coins[i]; j <= amount; j++) {
                /**
                 * 	如果钱包当前的价值j仅能允许放入一个w[i]，那么就要进行权衡，以获得更少的硬币数
                 * 		如果放入0个：此时钱包里面硬币的个数保持不变： v0=dp[j]
                 * 		如果放入1个：此时钱包里面硬币的个数为：		v1=dp[j-coins[i]]+1
                 * 		 【前提是dp[j-coins[i]]必须有值，如果dp[j-coins[i]]是无穷大，说明无法凑出j-coins[i]价值的钱包，
                 * 	              那么把w[i]放进去以后，自然也凑不出dp[j]的钱包】
                 * 	所以，此时当钱包价值为j时，里面的硬币数目为 dp[j]=min{v0,v1}
                 * 	如果钱包当前价值j能够放入2个w[i]，就要再进行一次权衡
                 * 		如果不放人第2个w[i]，此时钱包里面硬币数目为，v1=dp[j]=min{v0,v1}
                 * 		如果放入第2个w[i],  此时钱包里面硬币数目为，v2=dp[j-coins[i]]+1
                 * 	所以，当钱包的价值为j时，里面的硬币数目为dp[j]=min{v1,v2}=min{v0,v1,v2}
                 * 	钱包价值j能允许放入3个，4个.........w[i]，不断更新dp[j]，最后得到在仅使用前i个硬币的时候，每个钱包里的最少硬币数目
                 */
                if(dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        return -1;
    }


    public int coinChange2(int[] coins, int amount) {
            Arrays.sort(coins);

            //count为硬币的数量
            recursion(coins, amount, 0, coins.length - 1);
            return minCount == Integer.MAX_VALUE ? -1 : minCount;
        }
        int minCount = Integer.MAX_VALUE;
        /**
         * 1、按金额从大到小，从多到少（排序，用余数一步到位）
         * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
         * 3、能整除即可返回
         */
        void recursion(int[] coins, int amount, int count, int index) {
            if (index < 0 || count + amount / coins[index] >= minCount) {
                return;
            }
            if (amount % coins[index] == 0) {
                minCount = Math.min(minCount, count + amount / coins[index]);
                return;
            }
            for (int i = amount / coins[index]; i >= 0; i--) {
                recursion(coins, amount - i * coins[index], count + i, index - 1);
            }
        }


    /**
     * 记忆化搜索
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }


    /**
     * 动态搜索
     *
     */
    public int coinChange4(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
    }

}
