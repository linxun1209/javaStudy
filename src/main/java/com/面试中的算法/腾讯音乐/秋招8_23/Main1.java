package com.面试中的算法.腾讯音乐.秋招8_23;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/23 19:12
 */
public class Main1 {
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(0);
        ListNode c=new ListNode(1);
        ListNode d=new ListNode(0);
        ListNode e=new ListNode(1);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

    }
    static int ans=0;
    public  int merge (ListNode a) {
        //递归
        if(a==null||a.next==null){
            return ans;
        }
        ListNode pre=new ListNode(-1);
        pre.next=a;
        if(!isPre(pre)){
            ans++;
        }
        return ans;


        // write code here
    }
    private  boolean isPre(ListNode pre){
        while (pre!=null&&pre.next!=null) {
            //两种条件
            if (pre.next.val == 0 && pre != null && pre.val != 0) {
                pre=pre.next;
                return true;

            } else if (pre.next.val != 0 && pre != null && pre.val == 0) {
                pre=pre.next;
                return true;

            }else {
                pre=pre.next;
                return false;
            }
        }
        pre=pre.next;
        return false;
    }
}

