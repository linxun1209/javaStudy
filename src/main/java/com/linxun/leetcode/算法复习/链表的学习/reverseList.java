package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 206. 反转链表
 * @date 2024/7/22 14:29
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = ans.next;
            ans.next = cur;
            cur = next;
        }
        return ans.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode ans = null;
        ListNode cur = head;
        while(cur != null){
            // 将下一个结点保存
            ListNode temp = cur.next;
            // 将当前节点与下一节点断开进行前置
            cur.next = ans;
            ans = cur;
            // 将当前指针指向下一个位置
            cur = temp;
        }
        return ans;
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

