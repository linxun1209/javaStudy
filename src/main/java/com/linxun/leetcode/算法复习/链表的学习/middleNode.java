package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 876. 链表的中间结点
 * @date 2024/7/19 20:43
 */
public class middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow  = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

