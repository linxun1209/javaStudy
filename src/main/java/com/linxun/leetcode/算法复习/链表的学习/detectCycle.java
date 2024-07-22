package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 142. 环形链表 II
 * @date 2024/7/22 10:35
 */
public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, p2 = head;
        boolean hasCycle = false;
        while (p2!= null && p2.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                hasCycle = true;
                break;
            }
        }

        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return q;
        } else
            return null;
    }



    public ListNode detectCycle3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

