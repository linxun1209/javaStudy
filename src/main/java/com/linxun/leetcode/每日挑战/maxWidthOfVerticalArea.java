package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/30 20:00
 */
public class maxWidthOfVerticalArea {
    public static void main(String[] args) {
        int[][] ans={{8,7},{9,9},{7,4},{9,7}};
        maxWidthOfVerticalArea(ans);
    }

    /**
     *
     * @param points
     * @return
     */
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int res = 0;
        for(int i = 1; i < points.length; i++){
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }


}
