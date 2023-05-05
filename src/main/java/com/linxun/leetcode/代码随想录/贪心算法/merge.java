package com.linxun.leetcode.代码随想录.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/5 18:24
 */
public class merge {
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        merge(arr);
    }



    public static int[][] merge(int[][] intervals) {
        int len = 0;
        for(int[] arr : intervals){
            if(arr[0] > len) {
                len = arr[0];
            }
            if(arr[1] > len) {
                len = arr[1];
            }
        }
        // new 一个新数组，长度是intervals 最大值的两倍，把intervals范围内的数*2填入数组
        // 【避免出现[1,3][4,5]，3和4中间是未覆盖部分，转化为[2,6][8,10]，6和8不连续】
        int[] data = new int[(len+1)*2];
        for(int[] arr : intervals){
            for(int i = arr[0]*2;i <= arr[1]*2;i++){
                data[i] = 1;
            }
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0;i < data.length;i++){
            if(data[i] == 1){   // 如果连续为1，则肯定是覆盖后的范围
                int start = i/2;
                while(i < data.length && data[i] == 1){
                    i++;
                }
                int end = (i-1)/2;
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][2]);
    }



    public int[][] merge2(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        //initial start 是最小左边界
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (intervals[i][0] > rightmostRightBound) {
                //加入区间 并且更新start
                res.add(new int[]{start, rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            } else {
                //更新最大右边界
                rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }


    public int[][] merge3(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{start, end});
            }
            else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
