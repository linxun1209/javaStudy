package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/3 13:00
 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.val, false) && dfs(root.right, root.val, true) && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean dfs(TreeNode root, int val, boolean moreThan) {
        if (root == null) {
            return true;
        }
        if (moreThan && root.val <= val) {
            return false;
        }
        if (! moreThan && root.val >= val) {
            return false;
        }
        if (root.left != null && ! dfs(root.left, val, moreThan)) {
            return false;
        }
        return root.right == null || dfs(root.right, val, moreThan);
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }


    /**
     * 递归
     */
    TreeNode max;
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

    // 简洁实现·递归解法
        public boolean isValidBST4(TreeNode root) {
            return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
        }
        boolean validBST(long lower, long upper, TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.val <= lower || root.val >= upper) {
                return false;
            }
            return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
        }
    // 简洁实现·中序遍历
        private long prev = Long.MIN_VALUE;
        public boolean isValidBST5(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (root.val <= prev) {
                // 不满足二叉搜索树条件
                return false;
            }
            prev = root.val;
            return isValidBST(root.right);
        }

}
