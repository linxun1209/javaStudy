package com.xingchen.Test;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.Test
 * @date 2022/9/3 20:53
 */
public class Main {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int len=nums.length;
        int sum=0;
        for (int i = 0; i < len; i++) {
            sum+=nums[i];
            if(sum<0){
                sum=0;
                continue;
            }
            sum=Math.max(sum,sum-nums[i]);


        }
        System.out.println(sum);

//        int[] dp=new int[len+1];
//        dp[0]=nums[0];
//        int sum=0;
//        for(int i=1;i<len;i++) {
//            sum+=nums[i];
//            dp[i] = Math.max(nums[i], sum);
//        }
//
//        System.out.println(dp[len]);


//        int sum=0;
//        for (int n = 0; n < nums.length; n++) {
//           sum+=nums[n];
//           if(sum<=0){
//               sum=nums[n+1];
//           }






    }
}
