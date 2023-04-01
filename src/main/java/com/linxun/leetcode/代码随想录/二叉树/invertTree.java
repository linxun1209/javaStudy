package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/1 20:41
 */
public class invertTree {

    /**
     * 利用层次遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        /**
         * 队列实现的
         * 层次遍历--直接左右交换即可
         */
        if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                TreeNode rightTree = node.right;
                node.right = node.left;
                node.left = rightTree;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            return root;
        }


    /**DFS递归
        /**
         * 前后序遍历都可以
         * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
         */
//        public TreeNode invertTree(TreeNode root) {
//            if (root == null) {
//                return null;
//            }
//            invertTree(root.left);
//            invertTree(root.right);
//            swapChildren(root);
//            return root;
//        }
//
//        private void swapChildren(TreeNode root) {
//            TreeNode tmp = root.left;
//            root.left = root.right;
//            root.right = tmp;
//        }
}
