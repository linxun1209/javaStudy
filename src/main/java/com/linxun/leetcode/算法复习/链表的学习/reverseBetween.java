package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 92. 反转链表 II
 * @date 2024/7/22 14:52
 */
public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;


        //2-4-6-3-7-8-null    2-4-7-3-6-8-null
        // cur=6-3-7-8-null pre=4-6-3-7-8-null next=3-7-8-null
        // cur.next=7-8-null  next.next=6-3-7-8-null pre.next=3-7-8-null



        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }


    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 第 3 步：切出一个子链表
        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        // 思考一下，如果这里不设置next为null会怎么样
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);
        // 第 5 步：接回到原来的链表中
        //想一下，这里为什么可以用rightNode
        pre.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;
    }
    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}


