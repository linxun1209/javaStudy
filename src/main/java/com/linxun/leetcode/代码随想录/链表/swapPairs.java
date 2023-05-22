package com.linxun.leetcode.代码随想录.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.链表
 * @date 2023/5/21 15:05
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        //递归法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

        public ListNode swapPairs2(ListNode head) {
//            迭代法
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
