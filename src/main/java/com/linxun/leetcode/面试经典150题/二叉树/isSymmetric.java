package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 101. 对称二叉树
 * @date 2024/4/2 22:32
 */
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return cmp(root.left,root.right);

    }
    private boolean cmp(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null||node1.val!=node2.val){
            return false;
        }
        return cmp(node1.left,node2.right)&&cmp(node1.right,node2.left);
    }



    /**
     * 递归法
     */
    public boolean isSymmetric2(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }


    public boolean isSymmetric4(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);
            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}

