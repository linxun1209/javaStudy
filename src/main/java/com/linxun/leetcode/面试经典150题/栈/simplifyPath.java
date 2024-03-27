package com.linxun.leetcode.面试经典150题.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 71. 简化路径
 * @date 2024/3/26 18:03
 */
public class simplifyPath {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}

