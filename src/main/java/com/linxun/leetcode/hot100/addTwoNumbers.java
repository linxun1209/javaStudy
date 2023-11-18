package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 15:13
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(-1),head=pre;
        int t=0;
        while (l1!=null||l2!=null||t!=0){
            if(l1!=null){
                t+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                t+=l2.val;
                l2=l2.next;
            }
            head.next=new ListNode(t%10);
            head=head.next;
            t/=10;
        }
        return pre.next;
    }

}
