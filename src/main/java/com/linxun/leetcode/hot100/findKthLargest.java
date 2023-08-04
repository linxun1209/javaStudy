package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/17 20:15
 */
public class findKthLargest {
    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        int k=2;
        findKthLargest(nums,k);
    }



    public static int findKthLargest(int[] nums, int k) {
        //找到最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        //根据最大值和最小值确定计数范围
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        //寻找第k大的数字
        for (int i = max - min; i >= 0; i--) {
            k -= count[i];
            if (k <= 0) {
                return i + min;
            }
        }
        return nums[0];
    }
}
