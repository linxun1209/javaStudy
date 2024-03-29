package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 19. 删除链表的倒数第 N 个结点
 * @date 2024/3/29 8:22
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode fast=head;
        ListNode slow=temp;
        int i=0;
        while(fast!=null){
            if(i>=n){
                slow=slow.next;
            }
            fast=fast.next;
            i++;
        }
        slow.next=slow.next.next;
        return temp.next;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp=new ListNode(0,head);
        ListNode first=head;
        ListNode second=temp;
        for(int i=0;i<n;i++){
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return temp.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        // 记住 待删除节点slow 的上一节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        prev.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;

        return dummy.next;
    }

}

