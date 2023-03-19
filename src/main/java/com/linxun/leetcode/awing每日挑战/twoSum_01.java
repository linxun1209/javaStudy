package com.linxun.leetcode.awing每日挑战;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.awing每日挑战
 * @date 2023/3/19 16:32
 */
public class twoSum_01 {


    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        if(nums.length==0||nums==null){
            return res;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                res[1]=i;
                res[0]=map.get(temp);
            }
            map.put(nums[i],i);
        }
        return res;


    }
}
