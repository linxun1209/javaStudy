package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/19 19:25
 */
public class rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int[] tempNums = new int[k];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            tempNums[index++] = nums[i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < tempNums.length; i++) {
            nums[i] = tempNums[i];
        }
    }

    class Solution {
        private void reverse(int[] nums, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }
    }
}
