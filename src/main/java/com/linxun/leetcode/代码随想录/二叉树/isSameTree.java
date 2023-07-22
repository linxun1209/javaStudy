package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/5/28 12:07
 */
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else if (q.val != p.val) {
            return false;
        }
        return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        Queue<TreeNode> que= new LinkedList<TreeNode>();
        que.offer(p);
        que.offer(q);
        while(!que.isEmpty()){
            TreeNode leftNode = que.poll();
            TreeNode rightNode = que.poll();
            if(leftNode == null && rightNode == null) {
                continue;
            }
            if(leftNode == null || rightNode== null || leftNode.val != rightNode.val) {
                return false;
            }
            que.offer(leftNode.left);
            que.offer(rightNode.left);
            que.offer(leftNode.right);
            que.offer(rightNode.right);
        }
        return true;
    }
}
