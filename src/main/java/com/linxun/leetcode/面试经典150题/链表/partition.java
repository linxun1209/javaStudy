package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description:  * 86. 分隔链表
 * @date 2024/3/29 9:12
 */
public class partition {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}

