package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/3 8:13
 */
public class moveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for (int i=index;i<nums.length;i++){
            nums[i]=0;
        }


    }
}
