package com.linxun.leetcode.awing每日挑战;



/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.awing每日挑战
 * @date 2023/3/19 16:36
 */
public class addTwoNumbers_02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
}
