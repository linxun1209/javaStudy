package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/29 16:54
 */
public class findNumberOfLIS {
    public static void main(String[] args) {
        int[] nums={1,3,5,4,7};
        findNumberOfLIS(nums);
    }
        public static int findNumberOfLIS(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int[] dp = new int[nums.length];
            for(int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }
            int[] count = new int[nums.length];
            for(int i = 0; i < count.length; i++) {
                count[i] = 1;
            }

            int maxCount = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j];
                        }
                    }
                    if (dp[i] > maxCount) {
                        maxCount = dp[i];
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (maxCount == dp[i]) {
                    result += count[i];
                }
            }
            return result;
        }
}
