package com.linxun.leetcode.面试经典150题.滑动窗口;

import java.util.Arrays;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 209. 长度最小的子数组
 * @date 2024/3/11 16:07
 */
public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=Integer.MAX_VALUE,sum=0;
       for (int i=0;i<nums.length;i++){
           sum+=nums[i];
           while (sum>=target){
               right=Math.min(right,i-left+1);
               sum-=nums[left++];
           }
       }
       return right==Integer.MAX_VALUE?0:right;

    }


    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }





    public int minSubArrayLen3(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }




    public int minSubArrayLen4(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public int minSubArrayLe4(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        int flag = 0;
        for (; right < nums.length; ) {
            if (flag == 0) {
                sum += nums[right];
            }
            if (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
                flag = 1;
                continue;
            }
            right++;
            flag = 0;
        }
        return (min == Integer.MAX_VALUE ? 0 : min);
    }
}

