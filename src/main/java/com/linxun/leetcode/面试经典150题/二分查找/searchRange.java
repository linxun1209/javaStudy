package com.linxun.leetcode.面试经典150题.二分查找;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @date 2024/8/8 16:02
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,1};
        res[0]=binarySearch(nums,target,true);
        res[1]=binarySearch(nums,target,false);
        return res;
    }


    private int binarySearch(int[] nums,int target,boolean leftOrange){
        int left=0,right=nums.length-1,ans=-1;
       while (left<=right){
           int mid=(right-left)/2+left;
           if(nums[mid]<target){
               left=mid+1;
           }else if(nums[mid]>target){
               right=mid-1;
           }else {
               ans=mid;
               if(leftOrange){
                   right=mid-1;
               }else {
                   left=mid+1;
               }
           }
       }
       return ans;
    }


    public int[] searchRange2(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            while (left<right&&target<nums[right]) {
                right--;
            }
            while (left<right&&target>nums[left]){
                left++;
            }
            if(nums[left]==target&&nums[right]==target){
                return new int[]{left,right};
            }else{
                break;
            }
        }
        return new int[]{-1,1};
    }
}

