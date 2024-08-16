package com.linxun.leetcode.面试经典150题.位运算;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 * 137. 只出现一次的数字 II
 * @date 2024/8/16 15:30
 */
public class singleNumber2 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            // two的相应的位等于1，表示该位出现2次
            two |= (one & num);
            // one的相应的位等于1，表示该位出现1次
            one ^= num;
            // three的相应的位等于1，表示该位出现3次
            three = (one & two);
            // 如果相应的位出现3次，则该位重置为0
            two &= ~three;
            one &= ~three;
        }
        return one;
    }


    public int singleNumber2(int[] nums) {
        // 首先排序
        Arrays.sort(nums);
        // 预定义返回变量
        int ans = -1;
        // 计算nums长度
        int len = nums.length;
        // 如果nums长度为1
        if (len == 1){
            return nums[0];
        }
        // 以长度3为间隔，遍历nums
        for(int i = 0; i< len;){
            if (nums[i] != nums[i+2]){
                ans = nums[i];
                break;
            }
            i = i+3;
            // 如果i 越界
            if (i >= len-1){
                ans = nums[i];
                break;
            }
        }
        // 返回结果
        return ans;
    }


    public int singleNumber3(int[] nums) {
        Map<Integer , Integer> map = new LinkedHashMap<>();
        for(Integer num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return 0;
    }
}

