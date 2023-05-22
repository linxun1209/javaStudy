package com.linxun.leetcode.代码随想录.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.链表
 * @date 2023/5/21 16:14
 */
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }

        }
        return false;
    }


}
