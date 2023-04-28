package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/4/28 8:59
 */
public class canJump {
    public static void main(String[] args) {
        int[] nums={3,2,1,0,4};
        canJump2(nums);
    }


    public static boolean canJump(int[] nums) {
        //令每一次跳一步
        int n=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=n){
                n=1;
            }else{
                n++;
            }
            if(i==0&&n>1){
                return false;
            }

        }
        return true;
    }


        public static boolean canJump2(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
            int coverRange = 0;
            //在覆盖范围内更新最大的覆盖范围
            for (int i = 0; i <= coverRange; i++) {
                coverRange = Math.max(coverRange, i + nums[i]);
                if (coverRange >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
}
