package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2022/9/5 20:50
 */


/**
 * 题目:27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素

 */


/**
 * 双指针
 */

public class removeElement27 {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r=nums.length-1;
        while (r>=0&&nums[r]==val) r--;
        while (l<=r){
            if (nums[l]==val){
                nums[l]=nums[r];
                r--;

            }
            l++;
            while (nums[r]==val) r--;
        }
        return l;

    }



}


/**
 * 单指针
 */
class Solution27 {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;


            }
        }
        return j;

    }
}
