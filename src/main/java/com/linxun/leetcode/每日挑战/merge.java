package com.linxun.leetcode.每日挑战;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/13 8:06
 */
public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m--+--n;

        while(n>=0) {
            nums1[i--] = m>=0 && nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1,right=n-1;
        for (int i=m+n-1;i>=0;i--){
            if(left>=0&&right>=0){
                if(nums1[left]>nums2[right]){
                    nums1[i]=nums1[left--];
                    continue;
                }else if(nums1[left]<=nums2[right]){
                    nums1[i]=nums2[right--];
                    continue;

                }
                if(left>=0){
                    return;
                }
            }if(right>=0){
                nums1[i]=nums2[right--];
            }
        }
    }


    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res=new LinkedList<>();
        Arrays.sort(intervals,(((o1, o2) -> Integer.compare(o1[0],o2[0]))));
        res.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=res.getLast()[1]){
                int start=res.getLast()[0];
                int end=Math.max(intervals[i][1],res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{start,end});
            }else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()-1][]);
    }
    public int[][] merge3(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> ans=new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            int l=intervals[i][0],r=intervals[i][1];
            if(ans.size()==0||ans.get(ans.size()-1)[1]<l){
                ans.add(new int[]{l,r});
            }else {
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],r);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static int[][] merge4(int[][] intervals) {
        int len=0;
        for (int[] arr:intervals){
            if(arr[0]>len) len=arr[0];
            if(arr[1]>len) len=arr[1];
        }
        int[] date=new int[(len+1)*2];
        for (int[] arr:intervals){
            for (int i=arr[0]*2;i<=arr[1]*2;i++){
                date[i]=1;
            }
        }
        List<int[]> ans=new ArrayList<>();
        for (int i=0;i<date.length;i++){
            if(date[i]==1){
                int start=i/2;
                while (i<date.length&&date[i]==1){
                    i++;
                }int end=(i-1)/2;
                ans.add(new int[]{start,end});
            }
        }
        return ans.toArray(new int[ans.size()-1][]);
    }

    public static void main(String[] args) {
        int[][] ans={{1,3},{2,6},{8,10},{15,18}};
        merge4(ans);
    }

}
