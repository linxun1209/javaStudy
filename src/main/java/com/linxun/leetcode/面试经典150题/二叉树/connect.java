package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 117. 填充每个节点的下一个右侧节点指针 II
 * @date 2024/4/3 8:18
 */
public class connect {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null&&root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null&&root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null){
            root.right.next=getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    /**
     * 这个方法用来判断根节点及左右子树和next结点是否存在,
     * 存在就返回该存在的结点,不存在就看根节点的下面的
     * 目的是用于上面更加灵活的判断
     * @param root
     * @return
     */
    public Node getNext(Node root){
        if(root==null){
            return null;
        }
        if(root.left!=null) {
            return root.left;
        }
        if(root.right!=null){
            return root.right;
        }
        if(root.next!=null) {
            return getNext(root.next);
        }
        return null;
    }


    public Node connect2(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }
    public Node connect3(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node node = null;
            Node nodePre = null;

            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    nodePre = queue.poll(); // 取出本层头一个节点
                    node = nodePre;
                } else {
                    node = queue.poll();
                    nodePre.next = node; // 本层前一个节点 next 指向当前节点
                    nodePre = nodePre.next;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            nodePre.next = null; // 本层最后一个节点 next 指向 null
        }
        return root;
    }
}

