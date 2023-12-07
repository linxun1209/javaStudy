package com.linxun.leetcode.hot100;

import com.java8的新特性.NewData;
import com.linxun.leetcode.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/18 22:33
 */

public class copyRandomList {

    Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        if(!map.containsKey(head)){
            Node headNew=new Node(head.val);
            map.put(head,headNew);
            headNew.next=copyRandomList(head.next);
            headNew.random=copyRandomList(head.random);
        }
        return map.get(head);
    }


    /**
     * 第一个for循环是复制节点并将复制节点插入到原节点的后面，第二个for循环是设置复制节点的random指针，
     * 第三个for循环是将复制节点从原链表中分离出来并恢复原链表的结构。最终返回复制链表的头节点。
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if(head==null){
            return null;
        }
        //第一个for循环的作用是复制链表的每一个节点，并将复制得到的节点插入到原节点的后面
        // 比如  A-B变成A-A-B-B

        for (Node node=head;node!=null;node=node.next.next){
            Node NodeNew=new Node(node.val);
            NodeNew.next=node.next;
            node.next=NodeNew;
        }

        //找到复制的那个结点然后对其的randow进行赋值
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

}
