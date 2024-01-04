package com.linxun.leetcode.hot100;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2024/1/4 11:40
 */
public class findMin {


    /**
     * 调库
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];

    }



    public int findMin1(int[] nums){
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
