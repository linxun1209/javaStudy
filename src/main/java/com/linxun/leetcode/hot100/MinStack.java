package com.linxun.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/26 20:04
 */
public class MinStack {
    Deque<Integer> xstack;
    Deque<Integer> minstack;
    public MinStack() {
        xstack=new LinkedList<>();
        minstack=new LinkedList<>();
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xstack.push(val);
        minstack.push(Math.min(minstack.pop(),val));

    }

    public void pop() {
        xstack.pop();
        minstack.pop();

    }

    public int top() {
        return xstack.peek();

    }

    public int getMin() {
        return minstack.peek();

    }

}
