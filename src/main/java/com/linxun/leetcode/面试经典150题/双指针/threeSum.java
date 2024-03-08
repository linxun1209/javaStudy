package com.linxun.leetcode.面试经典150题.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 15. 三数之和
 * @date 2024/3/8 23:33
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ans;
        }

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) {
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去掉重复情况
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                //循环出口
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作

                    // 去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        //这题采用双指针
        //首先先进行排序
        Arrays.sort(nums);
        //定义一个结果集合
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //这里的nums.length-2是为了保证最后还有两个数
        for(int k = 0; k < nums.length - 2; k++){
            //如果nums[k]>0的话那后面的值一定不会等于0，因为已经提前排好序了
            if(nums[k] > 0) break;
            //这里去重
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            //定义双指针
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                //三数相加
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0) {
                    //如果相加的和小于0，左指针前进并去重
                    while(i < j && nums[i] == nums[++i]);
                }else if(sum > 0){
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

}
