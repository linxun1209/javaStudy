package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2022/9/5 20:11
 */


/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums
 * 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *

 */

/**
 * 法一
 */
public class search704 {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(l<r&&nums[mid]<target){
                l=mid+1;

            }else if(l<r&&nums[mid]>target){
                r=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}


/**
 * 两者的区间边界问题处理的不同
 *
 */

/**
 * 法二
 */
class Solution127 {
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
}


