package com.linxun.leetcode.代码随想录.栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.栈与队列
 * @date 2023/3/27 9:26
 */
public class isValid {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else if (c == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }


        }
        return stack.isEmpty() ? true : false;
    }


    public boolean isValid2(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
