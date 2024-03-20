package com.linxun.leetcode.面试经典150题.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 128. 最长连续序列
 * @date 2024/3/15 18:04
 */
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1,max = 1,temp = 2;
        for (int i = 1; i < nums.length;) {
            if (nums[i] == nums[i-1]) {
                if (i == nums.length-1) {
                    break;
                }
                i++;
                continue;
            }
            if (nums[i] - nums[i-1] == 1) {
                count++;
                i++;
            }else {
                i = temp;
                count = 1;
                temp++;
                continue;
            }
            max = Math.max(count,max);
        }
        return max;
    }


    public int longestConsecutive2(int[] nums) {

        //去重
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    public int longestConsecutive3(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //首先排序
        Arrays.sort(nums);
        int result = 1;
        int now = 1;
        int front = nums[0];
        //遍历数组，当连续的时候更新最大值
        for(int i=1;i<nums.length;i++){
            if(nums[i]==front+1){
                now++;
                front = nums[i];
                result = Math.max(now,result);
            }else if(nums[i]==front){
                continue;
            }else{
                front = nums[i];
                now=1;
            }
        }
        return result;
    }
}

