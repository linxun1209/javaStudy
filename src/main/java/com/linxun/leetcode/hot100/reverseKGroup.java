package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/18 20:50
 */
public class reverseKGroup {

    public ListNode reverseKGroupTest(ListNode head, int k) {
        ListNode hot=head;
        for (int i=0;i<k;i++){
            if(hot==null){
                return head;
            }
            hot=hot.next;
        }
        ListNode pre=null,cur=head;
        while (cur!=hot){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        head.next=reverseKGroupTest(cur,k);
        return pre;
    }

    /**
     * 递归
     * 终止条件是元素结束
     * 递归目的是每次将k个元素旋转
     * 递归公式 每次前k个
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode post=head;
        //每次反转k个
        for (int i=0;i<k;i++){
            if(post==null){
                return head;
            }
            post=post.next;
        }
        //pre是翻转前一个结点 cur是当前节点 直到两者相遇循环结束
        ListNode pre=null,cur=head;
        while (cur!=post){
            //存储当前结点后面的结点供后面
            ListNode temp=cur.next;
            //把当前结点的下一个结点指向前一个结点
            cur.next=pre;
            //更新pre为当前节点cur
            pre=cur;
            //把当前节点为下一个结点的temp进入下一个循环
            cur=temp;
        }
        //开始递归
        head.next=reverseKGroup(cur,k);
        return pre;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        //定义一个假的节点。
        ListNode dummy=new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next=head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre=dummy;
        ListNode end=dummy;

        while(end.next!=null){
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for(int i=0;i<k&&end != null;i++){
                end=end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end==null){
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next=end.next;
            //然后断开链表
            end.next=null;
            //记录下要翻转链表的头节点
            ListNode start=pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next=reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next=next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre=start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end=start;
        }
        return dummy.next;


    }
    //链表翻转
    // 例子：   head： 1->2->3->4
    public ListNode reverse(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        while (curNode != null){
            nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
            curNode.next=preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
            curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
        }
        return preNode;

    }


    //提升指针作用域为成员变量
    ListNode pre = null;
    ListNode cur = null;
    public ListNode reverseKGroup3(ListNode head, int k) {
        int size = 0;
        ListNode temp4size = head;
        while(temp4size!=null) {
            size++;
            temp4size = temp4size.next;
        }
        int loopSize = size/k;
        //每轮翻转用的指针
        pre = head;
        cur = head.next;
        //用来保存最后的结果节点
        ListNode res = null;
        //用来保存上一轮翻转的最后一个节点来连接下一段
        ListNode temp = null;
        for(int i = 0;i<loopSize;i++) {
            //每次翻转
            reverse(k);
            //把第一次翻转的结果给结果节点
            if(i==0) res = pre;
            //从第二次开始要连接上一段
            if (i!=0) temp.next = pre;
            //得到当前段的后驱节点
            temp = pre;
            while (temp.next != null) {
                temp = temp.next;
            }
            //把指针移到下一段
            pre = cur;
            if(cur!=null) cur = cur.next;
        }
        temp.next = pre;
        return res;
    }

    public void reverse(int k) {
        pre.next = null;
        for(int j = 0;j<k-1;j++) {
            ListNode temp2 = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp2;
        }
    }
}
