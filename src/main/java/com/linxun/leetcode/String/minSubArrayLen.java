package com.linxun.leetcode.String;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.String
 * @date 2022/11/9 10:31
 */
public class minSubArrayLen {
    public static void main(String[] args) {
        int target=7;
        int[] nums={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
    public static int  minSubArrayLen(int target, int[] nums) {
        int l=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum+=nums[r];
            while (sum>=target) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l++];
            }
        }
        return result==Integer.MAX_VALUE?0:result;

    }
}