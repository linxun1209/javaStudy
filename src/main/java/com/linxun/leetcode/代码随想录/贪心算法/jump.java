package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/4/28 22:00
 */
public class jump {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
    public int jump2(int[] nums) {
        int result=0;
        int res=0;
        int end=0;
        for(int i=0;i<=end&&end<nums.length-1;i++){
            res=Math.max(res,i+nums[i]);
            if(i==end){
                end=res;
                result++;

            }
        }
        return result;
    }
}
