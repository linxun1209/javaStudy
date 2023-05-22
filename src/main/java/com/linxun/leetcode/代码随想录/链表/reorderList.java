package com.linxun.leetcode.代码随想录.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.链表
 * @date 2023/5/21 15:37
 */
public class reorderList {
    public void reorderList(ListNode head) {
        //双端队列
        Deque<ListNode> douQueue = new LinkedList<>();
        ListNode cur=head.next;
        while (cur != null) {
            douQueue.offer(cur);
            cur = cur.next;
        }
        cur = head;  // 回到头部
        int count=0;
        while (!douQueue.isEmpty()) {
            if(count%2==0){
                cur.next=douQueue.pollLast();
            }else {
                cur.next=douQueue.poll();
            }
            cur=cur.next;
            count++;

        }
        cur.next=null;
    }


    public void reorderList2(ListNode head) {
        // 双指针的做法
        ListNode cur = head;
        // ArrayList底层是数组，可以使用下标随机访问
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        cur = head;  // 重新回到头部
        int l = 1, r = list.size() - 1;  // 注意左边是从1开始
        int count = 0;
        while (l <= r) {
            if (count % 2 == 0) {
                // 偶数
                cur.next = list.get(r);
                r--;
            } else {
                // 奇数
                cur.next = list.get(l);
                l++;
            }
            // 每一次指针都需要移动
            cur = cur.next;
            count++;
        }
        // 注意结尾要结束一波
        cur.next = null;
    }

    public void reorderList3(ListNode head) {
        ListNode fast = head, slow = head;
        //求出中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //right就是右半部分 12345 就是45  1234 就是34
        ListNode right = slow.next;
        //断开左部分和右部分
        slow.next = null;
        //反转右部分 right就是反转后右部分的起点
        right = reverseList(right);
        //左部分的起点
        ListNode left = head;
        //进行左右部分来回连接
        //这里左部分的节点个数一定大于等于右部分的节点个数 因此只判断right即可
        while (right != null) {
            ListNode curLeft = left.next;
            left.next = right;
            left = curLeft;

            ListNode curRight = right.next;
            right.next = left;
            right = curRight;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode headNode = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = headNode.next;
            headNode.next = cur;
            cur = next;
        }
        return headNode.next;
    }
}
