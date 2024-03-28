package com.linxun.leetcode.面试经典150题.链表;

import com.linxun.leetcode.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 138. 随机链表的复制
 * @date 2024/3/28 12:51
 */
public class copyRandomList {

    /**
     * 先进行复制并且连接到一起，然后用最后一个循环来把两次一样的进行分开
     * 迭代 + 节点拆分
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        for (Node node=head;node!=null;node=node.next.next){
            Node NodeNew=new Node(node.val);
            NodeNew.next=node.next;
            node.next=NodeNew;
        }
        for (Node node=head;node!=null;node=node.next.next){
            Node nodeNew=node.next;
            nodeNew.random=(node.random!=null)?node.random.next:null;
        }
        Node headNew=head.next;
        for (Node node=head;node!=null;node=node.next){
            Node nodeNew=node.next;
            node.next=node.next.next;
            nodeNew.next=(nodeNew.next!=null)?nodeNew.next.next:null;
        }
        return headNew;
    }


    /**
     * 回溯+哈希表
     *
     */
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }
        return cachedNode.get(head);
    }

}

