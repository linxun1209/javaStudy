package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 112. 路径总和
 * @date 2024/4/3 11:22
 */
public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {// 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false; // 为空退出

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) return root.val == targetSum;

        // 求两侧分支的路径和
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }


    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if(root==null)return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);stack2.push(root.val);
        while(!stack1.isEmpty()){
            int size = stack1.size();
            for(int i=0;i<size;i++){
                TreeNode node = stack1.pop();int sum=stack2.pop();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if(node.left==null && node.right==null && sum==targetSum)return true;
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(node.right!=null){
                    stack1.push(node.right);stack2.push(sum+node.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(node.left!=null){
                    stack1.push(node.left);stack2.push(sum+node.left.val);
                }
            }
        }
        return false;
    }
}

