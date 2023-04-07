package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/7 13:37
 */
public class numMovesStonesII {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        //石头最大可放置空间=初始左右两端还未占用的空间 - min(左边第1,2颗之间空隙,右边第1,2颗之间空隙)
        int max = stones[n - 1] - stones[0] + 1 - n;
        max -= Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
        //石头最小可放置空间=n大小连续空间里初始有最多颗石头的情况(滑动n大小窗口)
        int min = max;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && stones[j] < stones[i] + n) {
                j++;
            }
            int cost = n - (j - i);//需要往stones[i]~stones[j]里移多少颗石头
            //考虑特殊情况3,4,5,6,10,此时不能移10->7,而必须移3->8,10->7,故为两次
            if (j - 1 - i == n - 2 && stones[j - 1] - stones[i] == n - 2) {
                cost = 2;
            }
            min = Math.min(min, cost);
        }
        return new int[]{min, max};
    }


    /**
     * 双指针
     *
     */
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            int n = stones.length;
            Arrays.sort(stones);
            if (stones[n - 1] - stones[0] + 1 == n) {
                return new int[]{0, 0};
            }
            int ma = Math.max(stones[n - 2] - stones[0] + 1, stones[n - 1] - stones[1] + 1) - (n - 1);
            int mi = n;
            for (int i = 0, j = 0; i < n && j + 1 < n; ++i) {
                while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                    ++j;
                }
                if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                    mi = Math.min(mi, 2);
                } else {
                    mi = Math.min(mi, n - (j - i + 1));
                }
            }
            return new int[]{mi, ma};
        }
    }

}
