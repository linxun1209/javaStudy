package com.linxun.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/25 19:26
 */
public class detectCycle {
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        boolean isCycle=false;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                isCycle=true;
                break;
            }
        }
        ListNode q=head;
        if(isCycle){
            while (q!=slow){
                q=q.next;
                slow=slow.next;
            }
            return q;
        }else{
            return null;
        }

    }


    /**
     * 哈希表
     * @param head
     * @return
     */

    public ListNode detectCycle2(ListNode head) {
        ListNode pre=head;
        Set<ListNode> set=new HashSet<>();
        while (pre!=null){
            if (set.contains(pre)){
                return pre;
            }else {
                set.add(pre);
            }
            pre=pre.next;
        }
        return null;

    }
}
