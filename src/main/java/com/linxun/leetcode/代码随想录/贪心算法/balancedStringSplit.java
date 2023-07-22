package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/29 16:10
 */
public class balancedStringSplit {
    class Solution {
        public int balancedStringSplit(String s) {
            int result = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'R') {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    result++;
                }
            }
            return result;
        }
    }
}
