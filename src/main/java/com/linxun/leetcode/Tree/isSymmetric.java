package com.linxun.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree
 * @date 2022/11/9 15:49
 */
//对称二叉树
    //迭代

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public static boolean check(TreeNode v,TreeNode u){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode poll1 = queue.poll();
            if(poll==null&&poll1==null){
                continue;
            }
            if((poll==null||poll1==null)||poll1.val!=poll.val){
                return false;
            }
            queue.offer(poll.left);
            queue.offer(poll1.right);
            queue.offer(poll.right);
            queue.offer(poll1.left);
        }
        return true;
    }
}

//迭代
class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}