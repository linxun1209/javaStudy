package com.linxun.leetcode.awing每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.awing每日挑战
 * @date 2023/3/19 17:20
 */
public class findMedianSortedArrays_04 {

    /**
     * 基本算法
     * @param args
     */
    public static void main(String[] args) {
        int[] num1={1,3};
        int[] num2={2};
        findMedianSortedArrays2(num1,num2);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int i=0,j=0;
        int[] tempArray=new int[m+n];
        while(i<n&&j<m){
            if(nums1[i]>=nums2[j]){
                tempArray[i+j]=nums2[j];
                j++;
            }
            else {
                tempArray[i+j]=nums1[i];
                i++;
            }
        }
        if(i==n){
            while(j<m){
                tempArray[i+j]=nums2[j];
                j++;
            }
        }else{
            while (i<n){
                tempArray[i+j]=nums1[i];
                i++;
            }
        }
        if (tempArray.length % 2 == 1) {
            return tempArray[(tempArray.length - 1) / 2];
        } else {

            return ((double) (tempArray[tempArray.length / 2] + tempArray[tempArray.length / 2 - 1])) / 2;
        }
    }


    /**
     * 递归算法
     *
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public static int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) {
            return nums2[j + k - 1];//nums1为空数组
        }
        if( j >= nums2.length) {
            return nums1[i + k - 1];//nums2为空数组
        }
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }


}
