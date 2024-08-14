package com.linxun.leetcode.面试经典150题.二分查找;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 * @date 2024/8/14 20:03
 */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp=new int[nums1.length+nums2.length];
        int i=0,j=0;
        while(i< nums1.length&&j<nums2.length){
            if(nums1[i]>=nums2[j]){
                temp[i+j]=nums2[j];
                j++;
            }else {
                temp[i+j]=nums1[i];
                i++;
            }
        }
        if(i==nums1.length){
            while (j<nums2.length){
                temp[i+j]=nums2[j];
                j++;
            }
        }else {
            while(i<nums1.length){
                temp[i+j]=nums1[i];
                i++;
            }
        }
        if(temp.length%2==1){
            return temp[(temp.length-1)/2];
        }else {
            return ((double) (temp[temp.length/2]+temp[temp.length/2-1]))/2;
        }
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
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


    public static double findMedianSortedArrays3(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }


}

