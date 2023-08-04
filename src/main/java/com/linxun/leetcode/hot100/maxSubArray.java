package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/4 14:03
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int sum=0;
        for (int n:nums){
            if(sum>0){
                sum+=n;
            }else {
                sum=n;
            }
            res=Math.max(res,sum);
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }

}
