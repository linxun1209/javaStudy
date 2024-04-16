package com.linxun.leetcode.面试经典150题.分治;

import com.linxun.leetcode.awing每日挑战.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * 148. 排序链表
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/25 19:56
 */
public class sortList {

    /**
     * 超出时间限制
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> ans=new ArrayList<>();
        while (head!=null){
            ans.add(head.next.val);
        }
        Arrays.sort(ans.toArray());
        ListNode pre=null;
        int i=0;
        while (ans.size()>0){
            pre.next.val=ans.get(i++);
        }
        return pre;


    }

    public ListNode sortList2(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //找到中间节点进行归并
        ListNode listNode=head,fast=head.next.next,l,r;
        while (fast!=null&&fast.next!=null){
            listNode=listNode.next;
            fast=fast.next.next;
        }
        r=mergeSort(listNode.next);
        //把head断开成左右两个
        listNode.next=null;
        l=mergeSort(head);
        return mergeList(l,r);
    }

    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode temp=new ListNode();
        ListNode p=temp;
        while (l!=null&&r!=null){
            if(l.val<r.val){
                p.next=l;
                l=l.next;
            }else {
                p.next=r;
                r=r.next;
            }
            p=p.next;
        }
        p.next=l==null?r:l;
        return temp.next;
    }


    /**
     * al生成的代码
     *
     * @param head
     * @return
     */
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 使用归并排序对链表进行排序
        ListNode mid = findMiddle(head);
        ListNode next = mid.next;
        mid.next = null; // 断开链表

        ListNode left = sortList3(head);
        ListNode right = sortList3(next);

        return merge(left, right);
    }

    // 找到链表的中间节点
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        // 处理剩余的节点
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }

        return dummy.next;
    }



    public ListNode sortList4(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=findMiddle2(head);
        mid.next=null;
         
        ListNode left=sortList4(head);
        ListNode right=sortList4(mid);
        
        return merge4(left,right);
    }

    private ListNode merge4(ListNode left, ListNode right) {
       ListNode pre=new ListNode();
       ListNode temp=pre;
       while (left!=null&&right!=null){
           if(left.val<=right.val){
               temp.next=left;
               left=left.next;
           }else{
               temp.next=right;
               right=right.next;
           }
           temp=temp.next;
       }
       if(right==null){
          temp.next=left;
       }
       if(left==null){
           temp.next=right;
       }
       return pre.next;
    }


    private ListNode findMiddle2(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
