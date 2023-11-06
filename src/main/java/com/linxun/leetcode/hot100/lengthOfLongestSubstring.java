package com.linxun.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 15:34
 *
 * 滑动窗口第一道
 * 无重复字符的最长字串
 *
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
        //滑动窗口维护一个窗口，右边的如果不包含就继续移动，如果包含则后面往前移动，知道遍历完毕，每次都找最大的窗口
        int res=0;
        Set<Character> set=new HashSet<>();
        int l=0,r=-1;
        while (1+r<s.length()){
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
