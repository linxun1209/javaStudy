package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 189. 轮转数组
 * @date 2024/3/4 10:13
 */
public class rotate {


    /**
     * 设置一个临时数组，临时数组存k个文件后面的数据，然后把当前的数组的数据原地改到i+k后面，然后把0-i用临时数组存进来
     *
     * @param nums
     * @param k
     */
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


    public void rotate2(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        //整体反转  1 2 3 4 5  ->   5 4 3 2 1
        reverse(nums, 0, n - 1);
        //0到k进行反转 k=2  4 5 3 2 1
        reverse(nums, 0, k - 1);
        //k到n进行反转   4 5 1 2 3
        reverse(nums, k, n - 1);
    }
}


