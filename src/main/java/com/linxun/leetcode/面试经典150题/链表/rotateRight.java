package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 61. 旋转链表
 * @date 2024/3/29 8:50
 */
public class rotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        //让该链表变成一个环
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public ListNode rotateRight2(ListNode head, int k) {
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


}

