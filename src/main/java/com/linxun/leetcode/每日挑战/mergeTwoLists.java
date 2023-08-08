package com.linxun.leetcode.每日挑战;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/5 22:33
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
}
