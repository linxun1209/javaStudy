package com.linxun.leetcode.awing每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.awing每日挑战
 * @date 2023/3/19 17:06
 */
public class lengthOfLongestSubstring_03 {
    public static void main(String[] args) {
        String a="abcabcbb";
        lengthOfLongestSubstring(a);
    }

    public static int lengthOfLongestSubstring(String s) {
        //-1相当于没有出现过
        int[] last=new int[128];
        for(int i=0;i<128;i++){
            last[i]=-1;
        }
        int n=s.length();
        int res=0;
        int start=0;
        for(int i=0;i<n;i++){
            int index=s.charAt(i);
            start=Math.max(start,last[index]+1);
            res=Math.max(res,i-start+1);
            last[index]=i;
        }
        return res;
    }
}
