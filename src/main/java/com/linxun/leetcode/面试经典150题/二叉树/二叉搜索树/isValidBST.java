package com.linxun.leetcode.面试经典150题.二叉树.二叉搜索树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 98. 验证二叉搜索树
 * @date 2024/4/10 8:01
 */
public class isValidBST {
    double last=-Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(isValidBST(root.left)){
            if(last<root.val){
                last=root.val;
                return isValidBST(root.right);
            }
        }
        return false;

    }



    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }



    public boolean isValidBST3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            //这里把根节点和左数的所有值存进去
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 一旦左边空了,就开始弹出,如果弹出的值比
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

