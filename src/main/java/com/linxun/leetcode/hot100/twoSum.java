package com.linxun.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 15:02
 *
 *
 *
 * 哈希第一题
 * 两数之和
 *
 */
public class twoSum {
    public int[] twoSum2(int[] nums, int target) {
        int[] ans=new int[2];
        if(nums==null&&nums.length==0){
            return ans;
        }
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }return ans;
    }
    public int[] twoSum4(int[] nums, int target) {
        int[] ans=new int[2];
        if(nums==null||nums.length==0){
            return ans;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                ans[0]=i;
                ans[1]=map.get(temp);
            }
            map.put(nums[i],i);
        }
        return ans;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        if(nums==null||nums.length==0){
            return ans;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                ans[1]=i;
                ans[0]=map.get(temp);

            }
            map.put(nums[i],i);
        }
        return ans;
    }


}
