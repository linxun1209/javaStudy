package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/17 23:11
 */
public class haveConflict {
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            double s1=getHoursMinutes(event1[0]);
            double end1=getHoursMinutes(event1[1]);
            double s2=getHoursMinutes(event2[0]);
            double end2=getHoursMinutes(event2[1]);
            if(s1>end2||s2>end1){
                return false;
            }else{
                return (Math.min(end1,end2)-Math.max(s1,s2))>=0? true:false;
            }
        }
        public double getHoursMinutes(String a){
            int hours=Integer.parseInt(a.substring(0,2).trim());
            int minutes=Integer.parseInt(a.substring(3,5).trim());
            return hours+minutes/60.0;
        }
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }

}
