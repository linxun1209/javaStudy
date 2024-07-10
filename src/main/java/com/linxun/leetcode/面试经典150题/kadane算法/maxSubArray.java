package com.linxun.leetcode.面试经典150题.kadane算法;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 53. 最大子数组和
 * @date 2024/7/10 9:45
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int sum=0;
        for (int i=0;i<nums.length;i++){
            if(sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            res=Math.max(res,sum);
        }
        return res;
    }
    public int maxSubArray2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int res=nums[0];
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i=0;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=res>dp[i]?res:dp[i];

        }
        return res;
    }


    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray3(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }



}

