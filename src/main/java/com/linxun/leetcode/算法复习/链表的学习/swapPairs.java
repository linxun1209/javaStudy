package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 24. 两两交换链表中的节点
 * @date 2024/7/22 16:00
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;

    }
    public ListNode swapPairs2(ListNode head) {

         //示例[1,2,3,4]
         ListNode pre = new ListNode(0);
         pre.next = head;
         ListNode temp = pre;
         while(temp.next != null && temp.next.next != null) {
             ListNode start = temp.next;//第一个节点 1
             ListNode end = temp.next.next;//第二个结点 2
             temp.next = end;  //把第二个结点赋值给第一个结点
             start.next = end.next;//把3赋值给
             end.next = start;
             temp = start;
         }
         return pre.next;


    }

}

