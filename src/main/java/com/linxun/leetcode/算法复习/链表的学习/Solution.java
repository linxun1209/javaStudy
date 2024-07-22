package com.linxun.leetcode.算法复习.链表的学习;

/**
 * LeetCode369.单链表加一
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        // 反转链表
        ListNode reversedHead = reverse(head);
        
        // 对链表进行加一操作
        ListNode current = reversedHead;
        int carry = 1; // 进位标志
        while (current!=null) {
            int sum = current.val + carry;
            current.val = sum % 10; // 当前节点的值更新为余数
            carry = sum / 10; // 更新进位标志
            if (carry == 0) {
                break; // 如果没有进位，跳出循环
            }
            current = current.next;
        }
        
        // 如果还有进位，创建一个新的节点
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        
        // 再次反转链表
        ListNode result = reverse(reversedHead);
        
        return result;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}