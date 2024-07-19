package com.linxun.leetcode.算法复习.链表的学习;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 234. 回文链表
 * @date 2024/7/19 19:05
 */
public class isPalindrome {
    public boolean isPalindrome(ListNode listNode){
        ListNode tmp=listNode;
        Stack<Integer> stack=new Stack<>();
        while (tmp!=null){
            stack.push(tmp.val);
            tmp=tmp.next;
        }
        //一边出栈一边比较
        while (listNode!=null){
            if(listNode.val!=stack.pop()) {
                return false;
            }
            listNode=listNode.next;

        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        Deque<ListNode> douQueue = new LinkedList<>();
        while(head != null){
            douQueue.addLast(head);
            head = head.next;
        }
        while(douQueue.size() > 1){
            ListNode h = douQueue.removeFirst();
            ListNode t = douQueue.removeLast();
            if(h.val != t.val){
                return false;
            }
        }
        return true;
    }

}

