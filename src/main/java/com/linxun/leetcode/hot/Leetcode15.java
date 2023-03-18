package com.linxun.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Hot100.hot
 * @date 2022/9/4 21:40
 */
public class Leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1,k=nums.length-1; j< k;) {
                if(j<i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while (nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                if(nums[i]+nums[j]+nums[k]==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }

            }



        }
        return ans;
    }
}
