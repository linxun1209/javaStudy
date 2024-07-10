package com.linxun.leetcode.面试经典150题.kadane算法;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 918. 环形子数组的最大和
 * @date 2024/7/10 10:28
 */
public class maxSubarraySumCircular {


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int[] leftMax=new int[n];
        leftMax[0]=nums[0];
        int leftSum=nums[0];
        int pre=nums[0];
        int res=nums[0];
        for (int i=1;i<n;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            res=Math.max(res,pre);
            leftSum+=nums[i];
            leftMax[i]=Math.max(leftMax[i-1],leftSum);
        }

        int rightSum=0;
        for (int i=n-1;i>0;i--){
            rightSum+=nums[i];
            res=Math.max(res,rightSum+leftMax[i-1]);
        }
        return res;
    }


    /**
     * 取反
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular2(int[] nums) {
        int n=nums.length;
        int preMax=nums[0],maxRes=nums[0];
        int preMin=nums[0],minRes=nums[0];
        int sum=nums[0];
        for (int i=1;i<n;i++){
            preMax=Math.max(preMax+nums[i],nums[i]);
            maxRes=Math.max(maxRes,preMax);
            preMin=Math.min(preMin+nums[i],nums[i]);
            minRes=Math.min(minRes,preMin);
            sum+=nums[i];
        }
        if(maxRes<0){
            return maxRes;
        }else {
            return Math.max(maxRes,sum-maxRes);
        }
    }


    /**
     * 单调栈
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular3(int[] nums) {
        int n=nums.length;
        Deque<int[]> deque=new ArrayDeque<>();
        int pre=nums[0],res=nums[0];
        deque.offerLast(new int[]{0,pre});
        for (int i=1;i<2*n;i++){
            while (!deque.isEmpty()&&deque.peekFirst()[0]<i-n){
                deque.pollFirst();
            }
            pre+=nums[i%n];
            res=Math.max(res,pre-deque.peekFirst()[1]);
            while (!deque.isEmpty()&&deque.peekLast()[1]>=pre){
                deque.pollLast();
            }
            deque.offerLast(new int[]{i,pre});
        }
        return res;
    }
}

