package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2022/9/5 10:47
 */
class ListNode {
    int val;
      ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        while (l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                cur.next=l2;
                l2=l2.next;
            }
            else {
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return pre.next;


    }
}
