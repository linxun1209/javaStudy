package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 141. 环形链表
 * @date 2024/3/27 8:53
 */
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 空链表、单节点链表一定不会有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针，一次移动两步
            slow = slow.next;      // 慢指针，一次移动一步
            if (fast == slow) {   // 快慢指针相遇，表明有环
                return true;
            }
        }
        return false; // 正常走到链表末尾，表明没有环
    }
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if (!set.add(head)) {

                return true;
            }
            head=head.next;
        }
        return false;
    }


    public boolean hasCycle3(ListNode head) {
        return check(head);
    }
    public boolean check(ListNode node){
        if(node==null||node.next==null)return false;
        node.val=Integer.MAX_VALUE;
        if(node.next.val==Integer.MAX_VALUE)return true;
        return check(node.next);
    }
}

