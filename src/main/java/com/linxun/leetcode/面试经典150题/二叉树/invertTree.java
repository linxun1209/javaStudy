package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 226. 翻转二叉树
 * @date 2024/4/2 21:58
 */
public class invertTree {
    // 先序遍历--从顶向下交换
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        //返回处理完的根节点
        return root;
    }
}

