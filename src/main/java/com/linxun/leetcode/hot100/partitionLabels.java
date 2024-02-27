package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2024/2/17 11:17
 */
public class partitionLabels {
    public static void main(String[] args) {
        String s="ababcbacadefegdehijhkli";
        partitionLabels2(s);
    }
    public static List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        while(i < S.length()) {
            //记录划分后每个片段的首字母
            char c = S.charAt(i);
            //记录首字母第一次和最后一次出现的位置
            int first = S.indexOf(c),last = S.lastIndexOf(c);
            //在[firsrt+1,last]区间内找有没有字母最后出现的位置超过last，若有则改变last的值
            for (int j = first+1; j <= last; j++) {
                if(S.lastIndexOf(S.charAt(j)) > last)
                    last = S.lastIndexOf(S.charAt(j));
            }
            //最终的last-first+1就是每个片段的长度
            ans.add(last-first+1);
            //将下个片段的首字母移动到last+1
            i = last + 1;
        }
        return ans;
    }


    public static List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}
