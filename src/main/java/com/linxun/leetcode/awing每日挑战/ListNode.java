package com.linxun.leetcode.awing每日挑战;

import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.awing每日挑战
 * @date 2023/3/19 16:38
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this .val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
