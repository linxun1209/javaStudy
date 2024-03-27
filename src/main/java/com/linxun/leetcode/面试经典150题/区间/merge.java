package com.linxun.leetcode.面试经典150题.区间;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 56. 合并区间
 * @date 2024/3/20 8:45
 */
public class merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public int[][] merge2(int[][] intervals) {
        int len = 0;
        for(int[] arr : intervals){
            if(arr[0] > len) len = arr[0];
            if(arr[1] > len) len = arr[1];
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

