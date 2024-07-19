package com.linxun.leetcode.算法复习.链表的学习;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 两个链表的第一个公共子节点问题
 * @date 2024/7/19 18:56
 */
public class getIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        while (headA!=null){
            stack1.push(headA);
            headA=headA.next;
        }
        while (headB!=null){
            stack2.push(headB);
            headB=headA.next;
        }
        ListNode temp=null;
        while (stack1.size() > 0 && stack2.size() > 0) {
            if(stack1.peek()==stack2.peek()){
                temp=stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return temp;
    }
}

