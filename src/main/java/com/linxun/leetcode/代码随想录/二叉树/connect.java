package com.linxun.leetcode.代码随想录.二叉树;
//
///**
// * @author xingchen
// * @version V1.0
// * @Package com.linxun.leetcode.代码随想录.二叉树
// * @date 2023/3/31 16:33
// */
//public class connect {
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        if(root.left!=null){
//            root.left.next=root.right;
//            if(root.next!=null){
//                root.right.next=root.next.left;
//            }
//            connect(root.left);
//            connect(root.right);
//        }
//
//        return root;
//    }
//
//}
//class Node{
//    public int val;
//    public com.linxun.leetcode.Node left;
//    public com.linxun.leetcode.Node right;
//    public com.linxun.leetcode.Node next;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, com.linxun.leetcode.Node _left, com.linxun.leetcode.Node _right, com.linxun.leetcode.Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}

import com.linxun.leetcode.Node;

import java.util.LinkedList;
import java.util.Queue;

public class connect {
    public Node connect(Node root) {
        Queue<Node> tmpQueue = new LinkedList<Node>();
        if (root != null) {
            tmpQueue.add(root);
        }

        while (tmpQueue.size() != 0){
            int size = tmpQueue.size();

            Node cur = tmpQueue.poll();
            if (cur.left != null) {
                tmpQueue.add(cur.left);
            }
            if (cur.right != null) {
                tmpQueue.add(cur.right);
            }

            for (int index = 1; index < size; index++){
                Node next = tmpQueue.poll();
                if (next.left != null) {
                    tmpQueue.add(next.left);
                }
                if (next.right != null) {
                    tmpQueue.add(next.right);
                }

                cur.next = next;
                cur = next;
            }
        }

        return root;
    }

    public void traversal(Node cur) {
        if (cur == null) {
            return;
        }
        if (cur.left != null) {
            cur.left.next = cur.right; // 操作1
        }
        if (cur.right != null) {
            if(cur.next != null) {
                cur.right.next = cur.next.left; //操作2
            } else {
                cur.right.next = null;
            }
        }
        traversal(cur.left);  // 左
        traversal(cur.right); //右
    }
    public Node connect2(Node root) {
        traversal(root);
        return root;
    }

    public Node connect3(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> que = new LinkedList<Node>();
        que.offer(root);
        Node nodePre = null;
        Node node = null;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i=0; i<size; i++) { // 开始每一层的遍历
                if (i == 0) {
                    nodePre = que.peek(); // 记录一层的头结点
                    que.poll();
                    node = nodePre;
                } else {
                    node = que.peek();
                    que.poll();
                    nodePre.next = node; // 本层前一个节点next指向本节点
                    nodePre = nodePre.next;
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            nodePre.next = null; // 本层最后一个节点指向null
        }
        return root;
    }
}