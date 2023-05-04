package com.linxun.leetcode.代码随想录.贪心算法;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/4 22:35
 */
public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) ->{ // 按照h升序，h相同按k降序排列
            return p1[0] == p2[0] ? p2[1] - p1[1] : p1[0] - p2[0];
        });
        int[][] res= new int[people.length][];
        for (int[] p : people) {    // 从左向右，计数插入。因为已入队人均矮于自己，计数空位等于自己的k时插入
            int count = p[1], pos = 0;// count为需要跳过的空位数，pos为从左向右的指针
            while (res[pos] != null || count != 0){
                if(res[pos] == null){ // 如果该位为空，则记录空位数
                    count--;          // 否则仅移动指针
                }
                pos++;
            }
            res[pos] = p;
        }
        return res;
    }
}
