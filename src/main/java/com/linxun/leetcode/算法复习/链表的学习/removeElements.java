package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 203. 移除链表元素
 * @date 2024/7/20 16:51
 */
public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return temp.next;
    }
}

