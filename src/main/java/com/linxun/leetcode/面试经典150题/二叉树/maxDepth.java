package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 104. 二叉树的最大深度
 * @date 2024/4/2 18:09
 */
public class maxDepth {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }



    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }



    public int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            add(root);
        }};
        int depth = 0;
        while(!queue.isEmpty()){
            int cursize = queue.size();
            for(int i = 0; i < cursize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}

