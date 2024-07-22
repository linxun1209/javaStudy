package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 拼接两个字符串
 * @date 2024/7/22 8:52
 */
public class findFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1,ListNode phead2) {
        if (pHead1 == null || phead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = phead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = phead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }
}

