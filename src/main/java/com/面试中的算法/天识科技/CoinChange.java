package com.面试中的算法.天识科技;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/9 10:26
 */
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int[] result = coinChange(coins, amount);//找到最小需要的硬币数量
        System.out.println("Minimum number of coins required: " + result[amount]);
        System.out.println("Coins: " + Arrays.toString(getCoins(result, coins, amount)));//找到对应需要的硬币数组
    }

    public static int[] coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 用于存储凑成每个金额所需的最少硬币数量
        Arrays.fill(dp, amount + 1); // 初始化dp数组为一个不可能达到的大数
        dp[0] = 0; // 凑成金额为0，不需要任何硬币

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) { // 当前硬币面额小于等于目标金额
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    // dp[i - coin]表示之前已经计算过的金额，加上当前硬币，得到较小的数量
                }
            }
        }

        return dp;
    }

    public static int[] getCoins(int[] dp, int[] coins, int amount) {
        if (dp[amount] > amount) {
            // 无法凑成目标金额，返回-1
            return new int[]{-1};
        }

        int[] selectedCoins = new int[dp[amount]];
        int currAmount = amount;
        int index = dp[amount] - 1;

        while (currAmount > 0) {
            for (int coin : coins) {
                if (currAmount >= coin && dp[currAmount] == dp[currAmount - coin] + 1) {
                    // 当前硬币面额小于等于目标金额，并且选择该硬币后，数量减少1
                    selectedCoins[index--] = coin;
                    currAmount -= coin;
                    break;
                }
            }
        }

        return selectedCoins;
    }
}