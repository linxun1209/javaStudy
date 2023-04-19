package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/17 11:34
 */
public class partition {
        List<List<String>> lists = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();

        public List<List<String>> partition(String s) {
            backTracking(s, 0);
            return lists;
        }

        private void backTracking(String s, int startIndex) {
            //如果起始位置大于s的大小，说明找到了一组分割方案
            if (startIndex >= s.length()) {
                lists.add(new ArrayList(deque));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                //如果是回文子串，则记录
                if (isPalindrome(s, startIndex, i)) {
                    String str = s.substring(startIndex, i + 1);
                    deque.addLast(str);
                } else {
                    continue;
                }
                //起始位置后移，保证不重复
                backTracking(s, i + 1);
                deque.removeLast();
            }
        }

    /**
     * 判断是否是回文串
     * @param s
     * @param startIndex
     * @param end
     * @return
     */
        private boolean isPalindrome(String s, int startIndex, int end) {
            for (int i = startIndex, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
}
