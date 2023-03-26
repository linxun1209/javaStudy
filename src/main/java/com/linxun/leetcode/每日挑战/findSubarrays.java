package com.linxun.leetcode.每日挑战;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/26 8:06
 */
public class findSubarrays {
    public boolean findSubarrays(int[] nums) {
        int[] ans=new int[nums.length-1];
        int t=0;
        for(int i=0;i<nums.length-1;i++){
            ans[t++]=nums[i]+nums[i+1];
        }
        Arrays.sort(ans);
        for (int i=0;i<ans.length;i++){
            if(ans[i]==ans[i+1]){
                return true;
            }
        }
        return false;

    }


    /**
     * 直接遍历枚举法
     *
     * @param nums
     * @return
     */
    public boolean findSubarrays2(int[] nums) {
        for(int i=0;i<nums.length-2;++i) {
            for(int j=i+1;j<nums.length-1;++j) {
                if(nums[i]+nums[i+1]==nums[j]+nums[j+1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * map方法
     *
     * @param nums
     * @return
     */
    public boolean findSubarrays3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i< nums.length -1;i++){
            int sum = nums[i] + nums[i+1];
            map.put(sum, map.getOrDefault(sum,0) + 1);
            if(map.get(sum) >1) {
                return true;
            }
        }
        return false;
    }

    /**
     * set方法
     *
     * @param nums
     * @return
     */
    public boolean findSubarrays5(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!set.add(nums[i] + nums[i - 1])) {
                return true;
            }
        }
        return false;
    }
}
