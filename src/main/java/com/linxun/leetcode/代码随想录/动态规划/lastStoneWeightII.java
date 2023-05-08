package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/8 23:56
 */
public class lastStoneWeightII {
    public static void main(String[] args) {
        int[] ints={2,7,4,1,8,1};
        lastStoneWeightII(ints);
    }
        public static int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int i : stones) {
                sum += i;
            }
            int target = sum >> 1;
            //初始化dp数组
            int[] dp = new int[target + 1];
            for (int i = 0; i < stones.length; i++) {
                //采用倒序
                for (int j = target; j >= stones[i]; j--) {
                    //两种情况，要么放，要么不放
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
            return sum - 2 * dp[target];
        }
}
