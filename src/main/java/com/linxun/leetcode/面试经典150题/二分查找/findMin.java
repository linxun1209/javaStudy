package com.linxun.leetcode.面试经典150题.二分查找;

import java.util.Arrays;

/**
 * @author xing'chen
 * @version 1.0
 * 153. 寻找旋转排序数组中的最小值
 * @description: 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * @date 2024/8/8 16:41
 */
public class findMin {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];

    }

    public int findMin2(int[] nums){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)>>>1;
            if(nums[mid]<=nums[nums.length-1]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return nums[left];
    }


    int res1=Integer.MAX_VALUE;
    public int findMin4(int[] nums) {
        int left=0,right=nums.length;
        while (left<=right){
            int mid=(left+right)>>>1;
            if(nums[left]<=nums[mid]){
                res1=Integer.min(res1,nums[left]);
                left=mid+1;
            }else {
                res1=Integer.min(res1,nums[right]);
                right=mid-1;
            }

        }
        return res1;
    }


    int res = Integer.MAX_VALUE;
    public int findMin3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            //左数组有序,增大,最小值只可能在左数组的最左端
            if(nums[left] <= nums[mid]){
                res = Integer.min(res, nums[left]);
                left = mid + 1;
            }else {//右数组有序,最小值可能在右数组的最左端mid,也可能在左边
                res = Integer.min(res, nums[mid]);
                right = mid - 1;
            }
        }
        return res;
    }
}

