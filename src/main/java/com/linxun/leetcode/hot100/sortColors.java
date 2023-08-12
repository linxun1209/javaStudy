package com.linxun.leetcode.hot100;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/12 11:01
 */
public class sortColors {
    /**
     * 方法一
     * 分别对颜色进行排序，且颜色用数字表示并且是按照大小顺序来的
     * 转化为对无序数组进行排序
     * 直接调库对数组进行排序
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * 方法二
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int n1=0,n2=0,n3=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[n2++]=2;
                nums[n1++]=1;
                nums[n1]=0;
            }else if(nums[i]==1){
                nums[n2++]=2;
                nums[n1++]=1;
            }else {
                nums[n2++]=2;
            }
        }
    }


    /**
     * 方法三
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int r1 = -1;
        int r2 = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 2) {
                r2++;
                swap(nums,i,r2);
                if(nums[r2] < 1) {
                    r1++;
                    swap(nums,r1,r2);
                }
            }
        }
    }
    void swap(int[]nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
