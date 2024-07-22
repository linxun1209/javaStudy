package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 83. 删除排序链表中的重复元素
 * @date 2024/7/20 17:10
 */
public class deleteDuplicates {


    /**
     * 迭代算法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }


    /**
     * 递归算法
     * @param head
     * @return
     */

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            //  改链表为空或者该链表只有一个值
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}

