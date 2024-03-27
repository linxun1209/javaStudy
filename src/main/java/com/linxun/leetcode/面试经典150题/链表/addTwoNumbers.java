package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 2. 两数相加
 * @date 2024/3/27 9:04
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //迭代
        int next1=0;
        int total=0;
        ListNode temp=new ListNode();
        ListNode cur=temp;
        while(l1!=null&&l2!=null){
            total=l2.val+l1.val+next1;
            cur.next=new ListNode(total%10);
            next1=total/10;
            l1=l1.next;
            l2=l2.next;
            cur=cur.next;
        }
        while(l1!=null){
            total=l1.val+next1;
            cur.next=new ListNode(total%10);
            next1=total/10;
            l1=l1.next;
            cur=cur.next;

        }
        while(l2!=null){
            total=l2.val+next1;
            cur.next=new ListNode(total%10);
            next1=total/10;
            l2=l2.next;
            cur=cur.next;
        }
        if(next1!=0){
            cur.next=new ListNode(next1);
        }
        return temp.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(111), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;


    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {


        //递归法
        int total=l1.val+l2.val;
        int next1=total/10;
        ListNode ans=new ListNode(total%10);
        if(l1.next!=null||l2.next!=null||next1!=0){
            l1=l1.next!=null?l1.next:new ListNode(0);
            l2=l2.next!=null?l2.next:new ListNode(0);
            l1.val+=next1;
            ans.next=addTwoNumbers(l1,l2);



        }
        return ans;
    }

}

