package com.linxun.leetcode.hot;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 17:47
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dym=new ListNode(0);
        dym.next=head;
        ListNode pre=dym,fast=dym,slow=dym;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dym.next;
    }
}
