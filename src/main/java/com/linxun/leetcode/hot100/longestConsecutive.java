package com.linxun.leetcode.hot100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/23 20:23
 *
 *
 * 哈希第三题
 * 128最长连续序列
 *
 */
public class longestConsecutive {

    /**
     * 方法一
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max=1,count=1,temp=2;
        for (int i=1;i<nums.length;){
            //如果有重复数字进行过滤
            if(nums[i-1]==nums[i]){
                if(i==nums.length-1){
                    break;
                }
                i++;
                continue;
            }
            if(nums[i-1]+1==nums[i]){
                count++;
                i++;
            }else {
                i=temp;
                count=1;
                temp++;
                continue;
            }
            max=Math.max(count,max);
        }
        return max;
    }


    /**
     * 方法二
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums) {
            set.add(num1);
        }
        int longStreak = 0;
        for (int num_set2 : set) {
            if (!set.contains(num_set2 - 1)) {
                int currentNum = num_set2;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longStreak = Math.max(currentStreak, longStreak);
            }

        }
            return longStreak;
    }
}
