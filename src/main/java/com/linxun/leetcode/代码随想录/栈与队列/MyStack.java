package com.linxun.leetcode.代码随想录.栈与队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.栈与队列
 * @date 2023/3/27 9:14
 */
public class MyStack {
    private Queue<Integer> a;
    private Queue<Integer> b;

    public MyStack() {
        a=new LinkedList<>();
        b=new LinkedList<>();

    }

    public void push(int x) {
        a.offer(x);
        while (!b.isEmpty()){
            a.offer(b.poll());
        }
        Queue temp=a;
        a=b;
        b=temp;

    }

    public int pop() {
        return b.poll();

    }

    public int top() {
        return b.peek();

    }

    public boolean empty() {
        return b.isEmpty();

    }
}
