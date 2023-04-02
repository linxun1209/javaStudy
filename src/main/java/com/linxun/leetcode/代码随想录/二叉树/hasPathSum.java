package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/2 15:00
 */
public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false; // 为空退出
        }

        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 求两侧分支的路径和
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    /**
     * 迭代
     *
     * @param root
     * @param targetsum
     * @return
     */
    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int size = stack1.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();

                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if (node.left == null && node.right == null && sum == targetsum) {
                    return true;
                }
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}
