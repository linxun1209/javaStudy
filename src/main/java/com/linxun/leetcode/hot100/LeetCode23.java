package com.linxun.leetcode.hot100;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2022/9/5 11:41
 */
public class LeetCode23 {
    //632 1090 373 264 313 719 786 1439 1508 1675

    public ListNode mergeKLists(ListNode[] lists) {



        /**
         * 定义小顶堆
         */
        PriorityQueue<ListNode> queue=new PriorityQueue<>((x,y)->x.val-y.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists!=null){
                queue.offer(lists[i]);
            }


        }

        ListNode temp=new ListNode(-1);
        ListNode ans=temp;
        while (!queue.isEmpty()){
            ListNode top=queue.poll();
            ListNode node=new ListNode(top.val);
            ans.next=node;
            ans=ans.next;
            ListNode next=node.next;
            if(next!=null){
                queue.offer(next);
            }
        }
        return temp.next;

    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }
}
