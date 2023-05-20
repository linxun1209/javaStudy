package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/20 18:16
 */
public class search {
    public int search(int[] nums, int target) {
        if(nums[0]>target||nums[nums.length-1]<target){
            return -1;
        }
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;

            }else if(nums[mid]>target){
                r=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 左闭右闭区间
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return -1;
    }
}
