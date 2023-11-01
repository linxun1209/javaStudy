package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/1 22:16
 */
public class majorityElement {
    public int majorityElement(int[] nums) {
        int count=0;
        int m=nums[0];
        for (int i=0;i<nums.length;i++){
            if(m==nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    m=nums[i+1];
                }
            }

        }
        return m;
    }
}
