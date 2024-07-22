package com.linxun.leetcode.算法复习.链表的学习;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/7/22 16:42
 */
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode post=head;
        for(int i=0;i<k;i++){
            if(post==null) return head;
            post=post.next;
        }
        ListNode pre=null,cur=head;
        while(cur!=post){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
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


    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = head;
        int len = 0;//先计算出链表的长度
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        int n = len/k;//计算出有几组
        ListNode pre = dummyNode;
        cur = head;
        for(int i=0;i<n;i++) {
            for(int j=0;j<k-1;j++) {
                ListNode next = cur.next;
                cur.next = cur.next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }



    public ListNode reverseKGroup4(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //找到要处理的区间的末尾
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if (end == null){
                break;
            }
            //将要处理的区间裁剪下来
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            //执行反转
            pre.next = reverse2(start);
            // 上面pre.next和下面start.next两个指针是为了将反转的区间缝补回去
            start.next = next;
            //调整指针，为下一组做准备
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    //复用前面小节中的实现
    private ListNode reverse2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

