package com.linxun.leetcode.hot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 17:47
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dym=new ListNode(0);
        dym.next=head;
        ListNode pre=dym,fast=dym,slow=dym;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        //删去倒数第n个元素
        slow.next=slow.next.next;
        return dym.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode pre = new ListNode(0,head);
        int a = 0;
        ListNode current = pre;
        map.put(a,current);
        while(current.next!=null){
            a = a+1;
            current = current.next;
            map.put(a,current);
        }
        map.get(a-n).next=map.get(a-n+2);
        return pre.next;
    }
}
