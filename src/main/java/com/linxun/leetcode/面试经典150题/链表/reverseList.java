package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 反转链表
 * @date 2024/3/28 13:28
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }

    private  ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }


    public ListNode reverseList3(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return pre;

    }


    public ListNode reverseList4(ListNode head) {
        ListNode fast=head;
        ListNode slow=null;
        while(fast!=null){
            ListNode temp=fast.next;
            fast.next=slow;
            slow=fast;
            fast=temp;
        }
        return slow;

    }


}


