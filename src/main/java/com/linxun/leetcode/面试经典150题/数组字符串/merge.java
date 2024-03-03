package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 88合并两个有序数组
 * @date 2024/3/3 22:20
 */
public class merge {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n=3;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;

        while (n >= 0) {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }


    /**
     * 逆序双指针
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1,right=n-1;
        for(int i=m+n-1;i>=0;i--){
            if(left>=0&&right>=0){
                if(nums1[left]>nums2[right]){
                    nums1[i]=nums1[left--];
                    continue;
                }else if(nums1[left]<=nums2[right]){
                    nums1[i]=nums2[right--];
                    continue;

                }
            }
            if(left>=0){
                return;
            }if(right>=0){
                nums1[i]=nums2[right--];
            }
        }

    }
}

