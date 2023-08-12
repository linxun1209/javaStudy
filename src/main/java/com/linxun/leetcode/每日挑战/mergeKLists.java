package com.linxun.leetcode.每日挑战;

import com.linxun.leetcode.awing每日挑战.ListNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/12 10:07
 */
public class mergeKLists {
    /**
     * 有序合并k个有序数组
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for (int i=0;i<lists.length;i++){
            ans=mergeTwoKLists(ans,lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoKLists(ListNode ans, ListNode list) {
        if(ans==null||list==null){
            return ans!=null?ans:list;
        }
        ListNode node=new ListNode(0);
        ListNode temp=node,a=ans,b=list;
        while (a!=null&&b!=null){
            if(a.val<b.val){
                temp.next=a;
                a=a.next;
            }else {
                temp.next=b;
                b=b.next;
            }
            temp=temp.next;
        }
        temp.next=a!=null?a:b;
        return node.next;
    }

}
