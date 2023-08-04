package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/29 19:25
 */
public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int k=n-2;
        //找到第一个非递增数
        while (k>=0&&nums[k]>=nums[k+1]){
            k--;
        }
        if(k<0){
            reserve(nums,0,n-1);
        }else {
            int r=k+1;
            int l=n-1;
            while (r<l){
                int mid=l+r+1>>1;
                if(nums[mid]>nums[k]){
                    r=mid;
                }else {
                    l=mid-1;
                }
            }
            swap(nums,k,r);
            reserve(nums,k+1,n-1);
        }

    }
    void reserve(int[] arr,int r,int l){
        while (r<l){
            swap(arr,r,l);
            r++;
            l--;
        }


    }
    void swap(int[] arr,int r,int l){
        int temp=arr[r];
        arr[r]=arr[l];
        arr[l]=temp;
    }
}
