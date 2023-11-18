package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/17 21:34
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
        //迭代法
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;

    }


}
