package com.linxun.leetcode.每日挑战;

import java.util.HashSet;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/2 9:05
 */
public class flipgame {
    /**
     * 正反面为同一个数就不符合要求，其他的数都符合要求，
     * 那么把出现的所有数减去正反面同时出现的数，
     * 剩下的数就是符合题目要求的数， 返回其中的最小值即可
     * @param fronts
     * @param backs
     * @return
     */
    public int flipgame(int[] fronts, int[] backs) {
        //时间复杂度： o(n)  空间复杂度： o(n)
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < fronts.length; i++) {
            if(fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = 2001;
        for(int i = 0; i < fronts.length; i++) {
            if(!set.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            if(!set.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        return min == 2001 ?  0 : min;
    }

    public int flipgame2(int[] fronts, int[] backs) {
        //数组代替哈希表
        boolean[] set = new boolean[2001];
        for(int i = 0; i < fronts.length; i++)
        {
            if(fronts[i] == backs[i]) {
                set[fronts[i]] = true;
            }
        }
        int min = 2001;
        for(int i = 0; i < fronts.length; i++)
        {
            if(!set[fronts[i]]) {
                min = Math.min(min, fronts[i]);
            }
            if(!set[backs[i]]) {
                min = Math.min(min, backs[i]);
            }
        }
        return min == 2001 ?  0 : min;
    }
}
