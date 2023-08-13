package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/13 8:06
 */
public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m--+--n;

        while(n>=0) {
            nums1[i--] = m>=0 && nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1,right=n-1;
        for (int i=m+n-1;i>=0;i--){
            if(left>=0&&right>=0){
                if(nums1[left]>nums2[right]){
                    nums1[i]=nums1[left--];
                    continue;
                }else if(nums1[left]<=nums2[right]){
                    nums1[i]=nums2[right--];
                    continue;

                }
                if(left>=0){
                    return;
                }
            }if(right>=0){
                nums1[i]=nums2[right--];
            }
        }
    }

}
