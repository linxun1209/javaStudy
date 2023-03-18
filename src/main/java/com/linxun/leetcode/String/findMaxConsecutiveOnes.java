package com.linxun.leetcode.String;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.String
 * @date 2022/11/9 10:23
 *
 *
 *
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */

//摩尔投票法,一旦不符合就置为0
class findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        if(nums.length==0||nums==null){
            return 0;
        }
        int i=0;
        int tmp=0;
        while(i<nums.length){
            if(nums[i++]==1){
                count++;
                tmp=Math.max(tmp,count);
            }
            else {
                count=0;
            }
        }
        return count;
    }
}