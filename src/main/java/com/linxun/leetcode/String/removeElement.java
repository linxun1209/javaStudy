package com.linxun.leetcode.String;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.String
 * @date 2022/11/9 10:18
 */


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */


/**
 * 快慢指针1
 */
public class removeElement {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r=nums.length-1;
        while(r>=0&&nums[r]==val){
            r--;
        }
        while (l<=r){
            if(nums[l]==val){
                nums[l]=nums[r];
                r--;
            }
            l++;
            while (r>=0&&nums[r]==val){
                r--;
            }
        }
        return l;

    }
}
