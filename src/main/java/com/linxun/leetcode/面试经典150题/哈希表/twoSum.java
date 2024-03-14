package com.linxun.leetcode.面试经典150题.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 1. 两数之和
 * @date 2024/3/14 22:37
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

}

