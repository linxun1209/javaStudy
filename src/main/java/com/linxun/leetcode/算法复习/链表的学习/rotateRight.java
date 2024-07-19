package com.linxun.leetcode.算法复习.链表的学习;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 61. 旋转链表
 * @date 2024/7/19 20:49
 */
public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null||head.next==null)return head;
        List<ListNode> list=new ArrayList<>();
        ListNode li=head;
        while(li!=null){
            list.add(li);
            li=li.next;
        }
        int len=list.size();
        k%=len;
        if(k==0)return list.get(0);
        list.get(len-1).next=list.get(0);
        list.get(len-k-1).next=null;
        return list.get(len-k);
    }

    public ListNode rotateRight2(ListNode head,int k){
        if(head == null || k == 0){
            return head;
        }
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;

        //当头结点不为空的时候一直遍历，然后 len++
        // 遍历完之后 head  为空
        while(head != null){
            head = head.next;
            len++;
        }

        if((k % len) == 0){
            return temp;
        }

        //从这里 fast 开始移动，取模是为了防止 k 大于 len 的情况出现
        while((k % len) > 0){
            k--;
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode res = slow.next;
        slow.next  = null;
        fast.next = temp;
        return res;
    }

}

