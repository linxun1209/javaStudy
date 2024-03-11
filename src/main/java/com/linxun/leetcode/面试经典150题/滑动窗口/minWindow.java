package com.linxun.leetcode.面试经典150题.滑动窗口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/3/11 17:18
 */
public class minWindow {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (s.length() < t.length()) {
            return "";
        }
        int[] sp = new int[128];
        int[] tp = new int[128];
        for (char c : t.toCharArray()) {
            ++tp[c];
        }
        int min = m + 1, start = -1, end = -1;
        for (int l = 0, r = 0; r < m; r++) {
            sp[s.charAt(r)]++;
            if (r < n - 1) {
                continue;
            }
            while (check(sp, tp) && r - l + 1 >= n) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                    end = r;
                }
                --sp[s.charAt(l++)];
            }
        }
        return m<min?"":s.substring(start,end+1);
    }

    private boolean check(int[] sp, int[] tp) {
        for (int i=0;i<128;i++){
            if(sp[i]<tp[i]){
                return false;
            }
        }
        return true;
    }




    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow2(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

}

