package com.面试中的算法.腾讯音乐.秋招8_23;


import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/23 19:37
 */
public class makeCompleteTree {

    public TreeNode makeCompleteTree (TreeNode root) {
        if (root == null) {
            return null;
        }
        int count = countNodes(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            } else if (poll.left == null) {
                queue.offer(new TreeNode(1));
            } else if (poll.right != null) {
                queue.offer(poll.right);
            } else {
                if (count > 1) {
                    poll.right = new TreeNode(1);
                    count--;
                    queue.offer(poll.right);
                }

            }

        }
        return root;
    }

    private int countNodes (TreeNode root){
        if (root == null) {
            return 0;
        }

        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;

    }

    private boolean isTree(TreeNode node){
        if(node!=null&&node.left==null&&node.right==null){
            return true;
        }
        if(node!=null&&node.left!=null&&node.left.left==null){
            return true;
        }
        if(node.left!=null){
            isTree(node.left);
        }else if(node.right!=null){
            isTree(node.right);
        }

        return false;
    }

}

