package com.linxun.leetcode.面试经典150题.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 219. 存在重复元素 II
 * @date 2024/3/15 17:16
 */
public class containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;


    }


    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right < nums.length && right - left <= k; right++) {
                if (nums[left] == nums[right]) {
                    return true;
                }
            }
        }
        return false;
    }
}

