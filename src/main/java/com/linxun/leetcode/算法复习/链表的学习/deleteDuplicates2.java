package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 82. 删除排序链表中的重复元素 II
 * @date 2024/7/20 17:14
 */
public class deleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(-101);
        ListNode pre = dummyHead;
        pre.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }



    public ListNode deleteDuplicates2(ListNode head){
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(0,head);

        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x= cur.next.val;
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

