package com.linxun.leetcode.算法复习.链表的学习;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 445. 两数相加 II
 * @date 2024/7/22 16:17
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Deque<Integer> deque1=new ArrayDeque<>();
        Deque<Integer> deque2=new ArrayDeque<>();
        while (l1!=null){
            deque1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            deque2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode ans=null;
        while (!deque1.isEmpty()||!deque2.isEmpty()||carry!=0){
            int a=deque1.isEmpty()?0:deque1.pop();
            int b=deque2.isEmpty()?0:deque2.pop();
            int cur=a+b+carry;
            carry=cur/10;
            cur%=10;
            ListNode curnode=new ListNode(cur);
            curnode.next=ans;
            ans=curnode;
        }
        return ans;
    }

}

