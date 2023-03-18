package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2022/9/5 22:05
 */


/**
 * 904. 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/
 */


/**
 * 双指针
 */
public class totalFruit904 {
        public int totalFruit(int[] nums) {
            if (nums.length <= 2) {
                return nums.length;
            }
            int res = 0;
            int left = 0;
            int right = 1;
            int l = nums[left];
            int r = nums[right];
            while (right < nums.length) {
                if (nums[right] == r || nums[right] == l) {
                    res = Math.max(res, right - left + 1);
                    right++;
                } else {
                    left = right - 1;
                    l = nums[left];
                    r = nums[right];
                    while (left >= 1 && nums[left - 1] == l) {
                        left--;
                    }
                    res = Math.max(res, right - left + 1);
                }
            }
            return res;
        }
}

/**
 * 滑动窗口
 */

class Solution {
    public int totalFruit(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] cnt = new int[max + 1];
        int m = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            cnt[nums[right]]++;
            if (cnt[nums[right]] == 1) {
                m++;
            }
            while (m > 2) {
                cnt[nums[left]]--;
                if (cnt[nums[left]] == 0) {
                    m--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;

        }
        return res;
    }
}
