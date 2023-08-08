package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/8 22:32
 */
public class maxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        //贪心 + 前缀和思想
        int sum = 0, max = 0, min = 0;
        for(int val : nums)
        {
            sum += val;
            if(sum > max) {
                max = sum;
            } else if(sum < min) {
                min = sum;
            }
        }
        return max - min;
    }

    public int maxAbsoluteSum2(int[] nums) {
        //最大连续子串的最大值或者最小值
        int prevMax = nums[0], prevMin = nums[0], max = nums[0], min = nums[0];
        int m = Math.max(max, 0);
        int n = Math.min(min, 0);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], prevMax + nums[i]);
            min = Math.min(nums[i], prevMin + nums[i]);
            m = Math.max(max, m);
            n = Math.min(min, n);
            prevMax = max;
            prevMin = min;
        }
        return m + n >= 0 ? m : -n;
    }

    public int maxAbsoluteSum3(int[] nums) {
        int positiveMax = 0, negativeMin = 0;
        int positiveSum = 0, negativeSum = 0;
        for (int num : nums) {
            positiveSum += num;
            positiveMax = Math.max(positiveMax, positiveSum);
            positiveSum = Math.max(0, positiveSum);
            negativeSum += num;
            negativeMin = Math.min(negativeMin, negativeSum);
            negativeSum = Math.min(0, negativeSum);
        }
        return Math.max(positiveMax, -negativeMin);
    }
}
