package com.linxun.leetcode.面试经典150题.二分查找;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/7/10 11:23
 */
public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }

        }
        return right+1;

    }
}

