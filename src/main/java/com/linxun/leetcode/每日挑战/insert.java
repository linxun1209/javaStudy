package com.linxun.leetcode.每日挑战;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/28 20:56
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
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> res=new ArrayList<>();
//        int l=newInterval[0],r=newInterval[1];
//        for (int[] arr:intervals){
//            int r1=arr[1];
//            int l1=arr[0];
//            if(r1<l){
//                res.add(arr);
//            }
//            if(l1>r){
//                res.add(arr);
//            }
//            res.get(res.size()-1)[0]= Math.min(res.get(res.size()-1)[0],l);
//            res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],r);
//        }
//        return res.toArray(new int[res.size()-1][]);
//    }


    public int[][] insert4(int[][] intervals, int[] newInterval) {
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
    public int[][] insert3(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        //左侧区间
        while (i < n && intervals[i][1] < newInterval[0]) {

            ret.add(intervals[i]);
            i++;

        }

        //区间重叠 开始节点 一定小于等于newInterval的结束值 结束结点一定大于等于newInterval的开始值
        while (i < n && intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ret.add(newInterval);


        //右侧区间
        while (i < n && intervals[i][0] > newInterval[1]) {
            ret.add(intervals[i]);
            i++;
        }


        int[][] ans = new int[ret.size()][];
        for (int k = 0; k < ret.size(); ++k) {
            ans[k] = ret.get(k);
        }
        return ans;
    }
}
