package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/5 12:58
 */
public class trimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


    /**
     * 迭代方法
     *
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
        public TreeNode trimBST2(TreeNode root, int low, int high) {
            while (root != null && (root.val < low || root.val > high)) {
                if (root.val < low) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
            if (root == null) {
                return null;
            }
            for (TreeNode node = root; node.left != null; ) {
                if (node.left.val < low) {
                    node.left = node.left.right;
                } else {
                    node = node.left;
                }
            }
            for (TreeNode node = root; node.right != null; ) {
                if (node.right.val > high) {
                    node.right = node.right.left;
                } else {
                    node = node.right;
                }
            }
            return root;
        }
}
