package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 1669. 合并两个链表
 * @date 2024/7/19 19:47
 */
public class mergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for(int i = 0; i < a - 1;i++){
            preA = preA.next;
        }
        ListNode preB = preA;
        for(int i = 0; i < b - a + 2;i++){
            preB = preB.next;
        }
        preA.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = preB;
        return list1;
    }
}

