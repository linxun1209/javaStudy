package com.linxun.leetcode.面试经典150题.区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 452. 用最少数量的箭引爆气球
 * @date 2024/3/26 16:37
 */
public class findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
      /*
        贪心策略:
        按照左边界升序排列,比较当前气球的左边界point[i][0]与上一个气球的右边界point[i-1][1]大小
        1.point[i][0]>point[i-1][1]:说明上一个气球必须要一支箭射爆->res++
        2.point[i][0]<point[i-1][1]:说明当前气球与上一个气球有重叠,有机会一起射爆
            最关键的问题是我怎么知道最多有几个挨在一起的气球可以一箭射爆?
            可以维护之前一堆挨在一起的气球右边界的最小值min,一旦min<point[i][0],表明必须耗费一支箭射爆上一堆气球
        最后一堆气球无论怎也不会射爆,因为这个方法只会射爆前一堆气球,因此将res初始化为1,就相当于射爆最后一堆了
         */
        // 初始化为1
        int res = 1;
        // 按照左边界升序排列
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        // 注意从1遍历起
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                // 不重叠,消耗一支弓箭
                res++;
            } else {
                // 这里利用point[i][1]滚动维护当前堆气球的最小右边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return res;
    }

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}

