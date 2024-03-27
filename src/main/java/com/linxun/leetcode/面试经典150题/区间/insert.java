package com.linxun.leetcode.面试经典150题.区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 57. 插入区间
 * @date 2024/3/20 8:59
 */
public class insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while (i<n&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while (i<n&&intervals[i][0]<=newInterval[1]&&intervals[i][1]>=newInterval[0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;

        }
        res.add(newInterval);
        while (i<n&&intervals[i][0]>newInterval[1]){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()-1][]);
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int left=newInterval[0];
        int right=newInterval[1];
        boolean flag=false;
        List<int[]> ans=new ArrayList<>();
        for (int[] res:intervals){
            if(res[0]>right){
                if(!flag){
                    ans.add(new int[]{left,right});
                    flag=true;
                }
                ans.add(res);
            }else if(res[1]<left){
                ans.add(res);
            }else {
                left=Math.min(left,res[0]);
                right=Math.max(right,res[1]);
            }

        }
        if(!flag){
            ans.add(new int[]{left,right});

        }

        return ans.toArray(new int[ans.size()-1][]);
    }
}

