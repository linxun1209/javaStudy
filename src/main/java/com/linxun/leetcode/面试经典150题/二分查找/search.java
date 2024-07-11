package com.linxun.leetcode.面试经典150题.二分查找;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 33. 搜索旋转排序数组
 * @date 2024/7/11 15:14
 */
public class search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r - 1) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[0]) {
                l = mid;
            } else if (nums[mid] < nums[0]) {
                r = mid;
            }
        }
        if (nums[0] <= target && nums[l] >= target) {
            r = l;
            l = 0;
        } else if (l < nums.length - 1 && nums[nums.length - 1] >= target && nums[l + 1] <= target) {
            l = l + 1;
            r = nums.length - 1;
        } else {
            return -1;
        }
        int pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                pos = mid;
                break;
            }
        }
        return pos;
    }

}

