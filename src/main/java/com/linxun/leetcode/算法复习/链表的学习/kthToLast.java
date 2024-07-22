package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 面试题 02.02. 返回倒数第 k 个节点
 * @date 2024/7/20 16:16
 */
public class kthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode fast=head,slow=head;
        while (k-- > 0){
            fast=fast.next;
        }
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;

    }
}

