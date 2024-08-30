package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/29 17:59
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d=new ListNode(),pre=d;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                pre.next=list1;
                pre=pre.next;
                list1=list1.next;
            }else {
                pre.next=list2;
                pre=pre.next;
                list2=list2.next;
            }
        }
        if(list1!=null){
            pre.next=list1;
        }
        if (list2!=null){
            pre.next=list2;
        }
        return d.next;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
