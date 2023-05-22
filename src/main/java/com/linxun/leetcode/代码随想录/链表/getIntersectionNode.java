package com.linxun.leetcode.代码随想录.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.链表
 * @date 2023/5/21 16:27
 */
public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            int lenA = 0, lenB = 0;
            while (curA != null) { // 求链表A的长度
                lenA++;
                curA = curA.next;
            }
            while (curB != null) { // 求链表B的长度
                lenB++;
                curB = curB.next;
            }
            curA = headA;
            curB = headB;
            // 让curA为最长链表的头，lenA为其长度
            if (lenB > lenA) {
                //1. swap (lenA, lenB);
                int tmpLen = lenA;
                lenA = lenB;
                lenB = tmpLen;
                //2. swap (curA, curB);
                ListNode tmpNode = curA;
                curA = curB;
                curB = tmpNode;
            }
            // 求长度差
            int gap = lenA - lenB;
            // 让curA和curB在同一起点上（末尾位置对齐）
            while (gap-- > 0) {
                curA = curA.next;
            }
            // 遍历curA 和 curB，遇到相同则直接返回
            while (curA != null) {
                if (curA == curB) {
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }

    }
}
