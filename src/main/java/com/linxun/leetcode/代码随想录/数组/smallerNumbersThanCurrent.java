package com.linxun.leetcode.代码随想录.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/19 18:01
 */
public class smallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums={8,1,2,2,3,1};
        smallerNumbersThanCurrent(nums);
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 记录数字 nums[i] 有多少个比它小的数字
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                // 遇到了相同的数字，那么不需要更新该 number 的情况
                map.put(res[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}
