package com.linxun.leetcode.面试经典150题.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 155. 最小栈
 * @date 2024/3/27 8:01
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }



     class MinStack1{
         Stack<Integer> stack;

        public MinStack1() {
            stack = new Stack();
        }

        public void push(int val) {
            stack.push(val);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            } else {
                return 0;
            }
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                min = Math.min(min, stack.get(i));
            }
            return min;
        }
    }
}

