package com.linxun.leetcode.hot;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 15:34
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        //-1相当于没有出现过
        //128表示二级制的最大值
        //也就是assi码值的最大值
        int[] last = new int[128];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int start = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start= Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int res=0;
        Set<Character> set=new HashSet<>();
        int l=0,r=-1;
        while (r+1<s.length()){
            if(!set.contains(s.charAt(r+1))){
                set.add(s.charAt(r+1));
                r++;
            }else {
                set.remove(s.charAt(l));
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
