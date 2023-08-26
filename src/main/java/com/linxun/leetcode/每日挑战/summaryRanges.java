package com.linxun.leetcode.每日挑战;

import com.面试相关.day01.sort.SelectionSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/26 18:45
 */
public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
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
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
