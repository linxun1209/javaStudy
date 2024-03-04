package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 55. 跳跃游戏
 * @date 2024/3/4 11:32
 */
public class canJump {
    public static void main(String[] args) {
        int[] nums ={3,2,1,0,4};
        canJump2(nums);
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        /**
         * 初始可以覆盖的大小都是1
         */
        int coverRange=0;
        //在覆盖范围内更新最大的范围
        for (int i=0;i<=coverRange;i++){
            coverRange=Math.max(coverRange,i+nums[i]);
            if(coverRange>=nums.length-1){
                return true;
            }
        }
        return  false;

    }


    /**
     * 用于判断一个整数数组是否可以通过跳跃来达到最后一个元素。
     * 代码的逻辑是从倒数第二个元素开始向前遍历数组，
     * 如果当前元素的值大于等于之前累积的最大步数，
     * 则将最大步数重置为1，否则最大步数加1。如果在遍历完数组后，
     * 最大步数大于1，则返回false，表示无法到达最后一个元素，
     * 否则返回true，表示可以到达最后一个元素。
     * 如果是
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        //初始只能跳一步
        int ans=1;
        for (int i=nums.length-2;i>=0;i--){
            if(nums[i]>=ans){
                ans=1;
            }else {
                ans++;
            }
            if(i==0&&ans>1){
                return false;
            }
        }
        return true;
    }


    /**
     * 一步一步的跳
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        //步长
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            //取当前步长和剩余步长较大的一个
            step = Math.max(nums[i], step);
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            //步长为0意味着不能继续向下走
            if (step == 0) {
                return false;
            }
            //走一步步长减一
            step--;
        }
        return false;
    }
}

