package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 82. 删除排序链表中的重复元素 II
 * @date 2024/3/29 8:37
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = deleteDuplicates(head.next);
        }
        return head;
    }



    public ListNode deleteDuplicates3(ListNode head) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val)
                    node = node.next;
                pre.next = node.next;
            } else pre = pre.next;
            node = node.next;
        }
        return hair.next;
    }


    public ListNode deleteDuplicates4(ListNode head) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(-101);
        ListNode pre = dummyHead;
        pre.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}

