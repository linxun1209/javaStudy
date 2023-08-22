package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/22 20:11
 */
public class maxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int res=0;
        int l=0;
        //当坐在最左边的情况下
        while (l<seats.length&&seats[l]==0){
            ++l;
        }
        res=Math.max(res,l);
        while (l<seats.length){
            int r=l+1;
            while (r<seats.length&&seats[r]==0){
                ++r;
            }
            if(r==seats.length){
                //当坐在最右边的情况下
                res=Math.max(res,r-l-1);
            }else {
                //在两者之间的人
                res=Math.max(res,(r-l)/2);
            }
            l=r;
        }
        return res;
    }


    /**
     * 我们定义两个变量 first和 last分别表示第一个人和最后一个人的位置
     * ，用变量 ddd 表示两个人之间的最大距离。
     * 然后遍历数组 seats如果当前位置有人，如果此前 last 更
     * 新过，说明此前有人，此时更新 d=max⁡(d,i−last)d = \max(d, i - last)d=max(d,i−last)；如
     * 果此前 firstfirstfirst 没有更新过，说明此前没有人，此时更新 first=ifirst = ifirst=i。接下来更新 last=ilast = ilast=i。
     * 最后返回 max⁡(first,n−last−1,d/2)\max(first, n - last - 1, d / 2)max(first,n−last−1,d/2) 即可。
     * @param seats
     * @return
     */
    public int maxDistToClosest2(int[] seats) {
        int first=-1,last=-1;
        int d=0,n=seats.length;
        for (int i=0;i<n;i++){
            if(seats[i]==1){
                if(last!=-1){
                    d=Math.max(d,i-last);
                }
                if(first==-1){
                    first=i;
                }
                last=i;
            }
        }
        return Math.max(d/2,Math.max(first,n-last-1));
    }

}
