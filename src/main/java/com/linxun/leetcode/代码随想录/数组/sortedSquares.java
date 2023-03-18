package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2022/9/5 21:19
 */

/**
 *
 题目:977. 有序数组的平方



 给你一个按 非递减顺序 排序的整数数组 nums，返回
 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
/**
 * 双指针
 */
public class sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length;
        int[] ans=new int[nums.length];
        int temp=nums.length-1;

        while (l<=r){
            if (nums[l]*nums[l]>nums[r]*nums[r]){
                ans[temp--]=nums[l];
                l++;
            }else {
                ans[temp--]=nums[r];
                r++;
            }
        }
        return ans;
    }
}
