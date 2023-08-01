package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/1 20:59
 */
public class sumOfPower {
    public static void main(String[] args) {
        int[] nums={2,1,4};
        sumOfPower3(nums);
    }
    /**
     * 动态规划 + 前缀和
     * 空间未优化版
     * @param nums
     * @return
     */
    public static int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        // 表示以 nums[j] 结尾的子序列的最小值之和
        int[] dp = new int[nums.length];
        int[] preSum = new int[nums.length + 1];
        int res = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (nums[i] + preSum[i]) % mod;
            preSum[i + 1] = (preSum[i] + dp[i]) % mod;
            res = (int) ((res + (long) nums[i] * nums[i] % mod * dp[i]) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }

    /**
     * 动态规划 + 前缀和
     * 空间优化版
     * @param nums
     * @return
     */
    public int sumOfPower2(int[] nums) {
        Arrays.sort(nums);
        int dp = 0, preSum = 0;
        int res = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            dp = (nums[i] + preSum) % mod;
            preSum = (preSum + dp) % mod;
            res = (int) ((res + (long) nums[i] * nums[i] % mod * dp) % mod);
            if (res < 0) {
                res += mod;
            }
        }
        return res;
    }

    public static int sumOfPower3(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] pre_dp=new int[nums.length+1];
        int res=0,mod=1000000007;
        for (int i=0;i<nums.length;i++){
            dp[i]=(nums[i]+dp[i])%mod;
            pre_dp[i+1]=pre_dp[i]+dp[i];
            res=(int) ((res+(long)nums[i]*nums[i]%mod*dp[i])%mod);
            if(res<0){
                res+=mod;
            }
        }
        return res;
    }
}
