package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/24 21:02
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i+=2){
            if(i==nums.length-1){
                return nums[nums.length-1];
            }
            if(nums[i]!=nums[i-1]) {
                return nums[i-1];
            }
        }
        return -1;

    }
}
