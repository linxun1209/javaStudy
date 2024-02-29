package com.linxun.leetcode.hot100;

import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/26 19:09
 */
public class maxProduct {
    /**
     * 正序逆序都遍历一遍，取两者的最大值返回
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int ans = 1;
        int max = nums[0];
        for (int a : nums) {
            ans = ans * a;
            if (ans > max) {
                max = ans;
            }
            if (a == 0) {
                ans = 1;
            }
        }
        ans = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans *= nums[i];
            if (max < ans) {
                max = ans;
            }
            if (nums[i] == 0) {
                ans = 1;
            }
        }
        return max;
    }


    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        //一个保存最大的，一个保存最小的。
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0) {
                int tmp = imax; imax = imin; imin = tmp;
            }
            //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
