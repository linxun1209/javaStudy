package com.linxun.leetcode.面试经典150题.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 3. 无重复字符的最长子串
 * @date 2024/3/11 16:38
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
       int res=0;
        Set<Character> ols=new HashSet<>();
        int r=-1,l=0;
        while (r+l<s.length()){
            if(!ols.contains(s.charAt(r+1))){
                ols.add(s.charAt(r+1));
                r++;
            }else {
                ols.remove(s.charAt(l));
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] last=new int[128];
        for (int i=0;i<128;i++){
            last[i]=-1;
        }
        int n=s.length();
        int res=0;
        int start=0;
        for (int i=0;i<n;i++){
            int index=s.charAt(i);
            start=Math.max(start,last[index]+1);
            res=Math.max(res,i-start+1);
            last[index]=i;
        }
        return res;
    }
}

