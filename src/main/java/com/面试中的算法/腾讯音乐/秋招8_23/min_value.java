package com.面试中的算法.腾讯音乐.秋招8_23;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/23 19:51
 */
public class min_value {
    public long min_value (int[] nums, int m) {
        // write code here
        int len=nums.length;
        if(len<m){
            return len;
        }else if(len==m){
            return len-1;
        }else {
            return len-1;
        }
    }
}

