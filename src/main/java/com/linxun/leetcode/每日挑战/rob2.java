package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/17 11:41
 */
public class rob2 {
    public int rob(int[] nums) {
        if (nums==null&&nums.length==0){
            return 0;
        }
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        return Math.max(robAction(nums,0,len-1),robAction(nums,1,len));
    }

    private int robAction(int[] nums, int start, int end) {
        int x=0,y=0,z=0;
        for (int i=start;i<end;i++){
            y=z;
            z=Math.max(y,x+nums[i]);
            x=y;
        }
        return z;
    }
}
