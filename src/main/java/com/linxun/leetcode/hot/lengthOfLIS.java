package com.linxun.leetcode.hot;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/21 18:16
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        int[] ans={1,2,4,2};
        lengthOfLIS(ans);
    }


    public static int lengthOfLIS(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < num) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = num;
            if(lo == maxL) {
                maxL++;
            }
        }
        return maxL;


    }
}
