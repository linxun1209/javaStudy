package com.linxun.leetcode.代码随想录.栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.栈与队列
 * @date 2023/3/28 21:02
 */
public class evalRPN {


    /**
     * 就是一个后缀表达式
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        String operaters = "+-*/";
        for(String string : tokens){
            if(!operaters.contains(string)){
                s.push(Integer.valueOf(string));
                continue;
            }
            int b = s.pop();
            int a = s.pop();
            if(string .equals("+")){
                s.push(a + b);
            }else if(string.equals("-")){
                s.push(a - b);
            }else if(string.equals("*")){
                s.push(a * b);
            }else {
                s.push(a / b);
            }
        }
        return s.pop();
    }


    /**
     * 栈
     */
    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {
                // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());
                // 注意 - 和/ 需要特殊处理

            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
