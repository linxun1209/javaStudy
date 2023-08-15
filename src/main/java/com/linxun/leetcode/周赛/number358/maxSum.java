package com.linxun.leetcode.周赛.number358;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.周赛.number358
 * @date 2023/8/13 22:05
 */
public class maxSum {
    public int maxSum(int[] nums) {
        int max=-1;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(testA(nums[i])==testA(nums[j])){
                    max=Math.max(max,nums[i]+nums[j]);
                }
            }
        }
        return max;

    }

    private int testA(int num) {
        int max=Integer.MIN_VALUE;
        while (num>=0){
            max=Math.max(max,num%10);
            num/=10;
        }
        return max;

    }


    /**
     * 维护每个数位上的最大值即可
     * @param nums
     * @return
     */
    public int maxSum2(int[] nums) {
        int[] ap = new int[10];
        int MAX = -1;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE, m = nums[i];
            while (m != 0) {
                max = Math.max(m % 10, max);
                m /= 10;
            }
            if (ap[max] > 0) {
                MAX = Math.max(MAX, ap[max] + nums[i]);
                ap[max] = Math.max(ap[max], nums[i]);
            } else {
                ap[max] = nums[i];
            }
        }
        return MAX;
    }
}
