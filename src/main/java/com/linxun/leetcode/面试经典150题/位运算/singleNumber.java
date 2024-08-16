package com.linxun.leetcode.面试经典150题.位运算;

import java.util.Arrays;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 * 136. 只出现一次的数字
 * @date 2024/8/16 15:25
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i+=2){
            //如果到最后一个了都没return出去呢那说明最后一个肯定是，单独写一个判断防止数组越界。
            if(i == n-1) return nums[n-1];

            if(nums[i] != nums[i+1]) return nums[i];
        }
        return -1;

    }


    /**
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * @param nums
     * @return
     */

    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

