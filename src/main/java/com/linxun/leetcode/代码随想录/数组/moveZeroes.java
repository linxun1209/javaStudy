package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/19 19:20
 */
public class moveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        // int index=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[index]=nums[i];
        //         index++;

        //     }

        // }
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }

    }

    public void moveZeroes2(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        // 后面的元素全变成 0
        for (int j = slow; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

}
