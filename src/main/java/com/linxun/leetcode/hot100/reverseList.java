package com.linxun.leetcode.hot100;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/13 21:28
 */
public class reverseList {
    /**
     * 迭代
     * @param head
     * @return
     */

    public ListNode reverseList(ListNode head) {
        //头节点
        ListNode fast=head;
        //空结点
        ListNode slow=null;
        while (fast!=null){
            //分离head为两部分 fast和fast.next
            ListNode temp=fast.next;
            //令第一个结点变成最后一个结点
            fast.next=slow;
            //存储当前节点
            slow=fast;
            //继续开始赋值遍历
            fast=temp;
        }
        return slow;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reser(head,null);
    }

    private ListNode reser(ListNode head, ListNode pre) {
        if(head==null){
            return pre;
        }
        ListNode res=reser(head.next,head);
        head.next=pre;
        return res;

    }
    //尾递归
 public ListNode reverseList3(ListNode head) {
     return reverse(null,head);
 }

 private static ListNode reverse(ListNode pre,ListNode cur){
     if(cur==null) return pre;
     ListNode next = cur.next;
     cur.next = pre;
     return reverse(cur,next);
 }
}
