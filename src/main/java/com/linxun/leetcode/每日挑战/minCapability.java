package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/19 20:10
 */
public class minCapability {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        int k = 2;
        minCapability(nums,k);

    }
    public static int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }

        }
        return lower;
    }


    public static int minCapability2(int[] nums, int k) {
        int max=Arrays.stream(nums).max().orElse(Integer.MAX_VALUE);
        int min=0;
        while (min<max){
            int middle=(max+min)/2;
            int count=MaxStealCount(nums,middle);
            if(count<k){
                min=middle+1;
            }else {
                max=middle;
            }
        }
        return min;
    }

    private static int MaxStealCount(int[] nums, int middle) {
        int count=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]<=middle){
                count++;
                i++;
            }
        }
        return count;
    }

}
