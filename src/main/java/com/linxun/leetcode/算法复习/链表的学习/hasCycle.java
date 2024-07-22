package com.linxun.leetcode.算法复习.链表的学习;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 141. 环形链表
 * @date 2024/7/22 9:59
 */
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        return check(head);
    }
    public boolean check(ListNode node){
        if(node==null||node.next==null)return false;
        node.val=Integer.MAX_VALUE;
        if(node.next.val==Integer.MAX_VALUE)return true;
        return check(node.next);
    }

    public boolean hasCycle2(ListNode head) {
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



    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<ListNode>();

        while(pos != null){
            if(set.contains(pos)){
                return pos;
            }else{
                set.add(pos);
            }
            pos = pos.next;
        }
        return pos;
    }


    public ListNode detectCycle3(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<ListNode>();

        while(pos != null){
            if(set.contains(pos)){
                return pos;
            }else{
                set.add(pos);
            }
            pos = pos.next;
        }
        return pos;
    }





}

