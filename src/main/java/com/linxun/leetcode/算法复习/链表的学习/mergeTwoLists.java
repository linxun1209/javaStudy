package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 21. 合并两个有序链表
 * @date 2024/7/19 19:17
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode val1,ListNode val2) {
        ListNode listNode = new ListNode(-1);
        ListNode res = listNode;
        while (val1 != null || val2 != null) {
            if (val1 != null && val2 != null) {
                if (val1.val > val2.val) {
                    listNode.next = val2;
                    val2 = val2.next;
                } else if (val1.val < val2.val) {
                    listNode.next = val1;
                    val1 = val1.next;
                } else {
                    listNode.next = val1;
                    val1 = val1.next;
                    listNode=listNode.next;
                    listNode.next = val2;
                    val2 = val2.next;

                }
                listNode = listNode.next;
            } else if (val1 != null && val2 == null) {
                listNode.next = val1;
                val1 = val1.next;
                listNode = listNode.next;
            } else if (val1 == null && val2 != null) {
                listNode.next = val2;
                val2 = val2.next;
                listNode = listNode.next;
            }
        }
        return res.next;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }



    public ListNode merageTwoList3(ListNode list1, ListNode list2){
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

