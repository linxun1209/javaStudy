package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2022/9/5 21:40
 */

/**
 * 题目209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。

 */

/**
 * 滑动窗口
 *
 */
public class minSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        for (int r = 0; r < nums.length-1; r++) {
            sum+=nums[r];
            while (sum>=target) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l++];
            }



        }
        return result==Integer.MAX_VALUE?0:result;

    }
}