package com.linxun.leetcode.hot100;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2022/9/5 9:35
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']' || c == ')' || c == '}') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == '[') {
                    while (stack.pop() != ']') {
                        return false;
                    }
                } else if (c == '(') {
                    while (stack.pop() != ')') {
                        return false;
                    }
                } else if (c == '{') {
                    while (stack.pop() != '}') {
                        return false;
                    }
                }
            }


        }
        return stack.isEmpty()?true:false;


    }
}
