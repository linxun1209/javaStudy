package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/3 8:13
 */
public class moveZeroes {

    public void moveZeroes4(int[] nums) {
        if(nums.length==0||nums==null){
            return;
        }
        int left=0,right=0,n=nums.length;
        while(right<n){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
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
