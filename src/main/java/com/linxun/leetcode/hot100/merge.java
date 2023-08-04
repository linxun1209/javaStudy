package com.linxun.leetcode.hot100;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/4 15:08
 */
public class merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res=new LinkedList<>();
        Arrays.sort(intervals,((o1, o2) -> Integer.compare(o1[0],o2[0])));
        res.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=res.getLast()[1]){
                int starr=res.getLast()[0];
                int end=Math.max(intervals[i][1],res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{starr,end});
            }else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()-1][]);
    }


    public int[][] merge2(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged =new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            int L=intervals[i][0],R=intervals[i][1];
            if(merged.size()==0||merged.get(merged.size()-1)[1]<L){
                merged.add(new int[]{L,R});

            }else {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
