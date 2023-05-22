package com.linxun.leetcode.代码随想录.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.链表
 * @date 2023/5/21 15:18
 */
public class isPalindrome {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            //双端队列
            Deque<ListNode> douQueue = new LinkedList<>();
            while(head != null){
                douQueue.addLast(head);
                head = head.next;
            }
            while(douQueue.size() > 1){
                ListNode h = douQueue.removeFirst();
                ListNode t = douQueue.removeLast();
                if(h.val != t.val){
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * 使用数组
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        // 统计链表长度
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        int[] res = new int[len];
        // 将元素加到数组之中
        for (int i = 0; i < res.length; i++){
            res[i] = cur.val;
            cur = cur.next;
        }
        // 比较回文
        for (int i = 0, j = len - 1; i < j; i++, j--){
            if (res[i] != res[j]){
                return false;
            }
        }
        return true;
    }
    // 方法二，快慢指针
        public boolean isPalindrome2(ListNode head) {
            // 如果为空或者仅有一个节点，返回true
            if (head == null && head.next == null) {
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = head;
            while (fast != null && fast.next != null){
                pre = slow;
                // 记录slow的前一个结点
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;
            // 分割两个链表

            // 前半部分
            ListNode cur1 = head;
            // 后半部分。这里使用了反转链表
            ListNode cur2 = reverseList(slow);

            while (cur1 != null){
                if (cur1.val != cur2.val) {
                    return false;
                }

                // 注意要移动两个结点
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return true;
        }
        ListNode reverseList(ListNode head){
            // 反转链表
            ListNode tmp = null;
            ListNode pre = null;
            while (head != null){
                tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            }
            return pre;
        }

}
