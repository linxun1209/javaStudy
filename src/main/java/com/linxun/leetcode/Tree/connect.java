package com.linxun.leetcode.Tree;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree
 * @date 2022/11/10 16:23
 */


/**
 * 填充每个节点的下一个右侧节点指针
 *
 * 递归
 */
public class connect {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left.next=root.right;
            if(root.next!=null){
                root.right.next=root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }

        return root;
    }
}

