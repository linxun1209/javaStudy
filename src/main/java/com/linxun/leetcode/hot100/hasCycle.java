package com.linxun.leetcode.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/25 19:16
 */
public class hasCycle {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
       return false;

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

    public boolean hasCycle3(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if (!set.add(head)) {

                return true;
            }
            head=head.next;
        }
        return false;
    }

}
