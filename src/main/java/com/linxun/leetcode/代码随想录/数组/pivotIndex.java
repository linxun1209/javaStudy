package com.linxun.leetcode.代码随想录.数组;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/20 17:46
 */
public class pivotIndex {
    public static void main(String[] args) {
        int[] nums={1, 7, 3,6, 6, 5, 6};
        pivotIndex(nums);
    }

    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }

    public int findMiddleInde2x(int[] nums) {
        int countright=0;
        int countleft=0;
        if(nums.length==1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            //获取数组所有值的和
            countright+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            //初始赋值为左指针为0
            if(i==0){
                countleft=0;
            }
            else {
                countleft += nums[i - 1];
            }
            countright-=nums[i];
            if(countleft==countright) {
                return i;
            }
        }
        return -1;
    }
}
