package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 100. 相同的树
 * @date 2024/4/2 21:45
 */
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (q == null || p == null) return false;
        else if (q.val != p.val) return false;
        return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }


    public boolean isSameTree3(TreeNode p, TreeNode q) {
        // 广度优先
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        tmpQueue.offer(p);
        tmpQueue.offer(q);
        while(!tmpQueue.isEmpty()){
            p = tmpQueue.poll();
            q = tmpQueue.poll();
            if(p == null && q == null){
                continue;
            }
            if((p == null || q == null) || p.val != q.val){
                return false;
            }
            tmpQueue.offer(p.left);
            tmpQueue.offer(q.left);

            tmpQueue.offer(p.right);
            tmpQueue.offer(q.right);
        }
        return true;
    }
}

