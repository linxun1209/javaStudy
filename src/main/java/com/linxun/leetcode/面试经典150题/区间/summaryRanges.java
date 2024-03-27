package com.linxun.leetcode.面试经典150题.区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 228. 汇总区间
 * @date 2024/3/20 8:30
 */
public class summaryRanges {
    public static void main(String[] args) {
        int[] nums={0,1,2,4,5,7};
        summaryRanges(nums);
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int n=nums.length;
        int i,j=0;
        while (j<n){
            i=j;
            while (i<n-1&&nums[i+1]==nums[i]+1){
                i++;
            }
            String str;
            if(i-j>=1){
                str=""+nums[j]+"->"+nums[i];
            }else {
                str=""+nums[i];
            }
            res.add(str);
            j=i;
            j++;
        }
        return res;

    }


    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length || nums[i + 1] != nums[i] + 1) {
                if(start==i)
                    res.add(String.valueOf(nums[start]));
                else {
                    res.add(String.format("%d->%d",nums[start],nums[i]));
                    // 如果相邻元素之间的差值为1，不需执行任何操作，继续遍历。
                }
                start = i+1;
            }

        }
        return res;
    }


    public List<String> summaryRanges3(int[] nums) {
        if(nums.length == 1){
            return Arrays.asList(nums[0] + "");
        }
        int left = 0;
        int right = 0;
        List<String> list = new ArrayList<>();
        while(right < nums.length-1) {
            if(nums[right] + 1 == nums[right+1]) {
                if(right + 1 == nums.length - 1) {
                    list.add(nums[left] + "->" + nums[right + 1]);
                }
                right++;
            } else {
                if(right - left > 0) {
                    //区间
                    list.add(nums[left] + "->" + nums[right]);
                } else {
                    list.add(nums[right] + "");
                }
                if(right + 1 == nums.length - 1) {
                    list.add(nums[right+1] + "");
                }
                left = right+1;
                right++;
            }
        }
        return list;
    }

}

