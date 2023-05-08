package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/8 23:35
 */
public class canPartition {
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        canPartition(nums);
    }


    public static boolean canPartition(int[] nums) {
        if(nums.length==1){
            return false;
        }
        int len=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        int w=sum/2;
        int[] dp=new int[w+1];
        dp[0]=1;
        for(int i:nums){
            for(int j=w;j>=i;j--){
                dp[j]+=dp[j-i];
            }
        }
        return dp[w]!=0;

    }
}
