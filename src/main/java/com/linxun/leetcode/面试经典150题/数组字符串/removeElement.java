package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 21移除元素
 * @date 2024/3/3 22:41
 */
public class removeElement {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int j=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;

    }


    /**
     * 双指针思路
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int l=0,r=nums.length;
        while (r>=0&&nums[r]==val) r--;
        while (l<=r){
            if(nums[l]==val){
                nums[l]=nums[r];
                r--;
            }
            l++;
            while (nums[r]==val) r--;
        }
        return l;
    }



}

