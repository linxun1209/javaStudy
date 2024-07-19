package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: LCR 078. 合并 K 个升序链表
 * @date 2024/7/19 19:41
 */
public class mergeKLists {
    public  ListNode mergeKLists(ListNode[] lists){
        ListNode res = null;
        for(ListNode list:lists){
            res = merageTwoLists(res,list);
        }
        return res;
    }
    public ListNode merageTwoLists(ListNode list1, ListNode list2){
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while(list1 != null && list2 !=null){
            if(list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = list1 == null ? list2:list1;
        return res.next;
    }
}

