package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/5 12:28
 */
public class insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }


    /**
     * 迭代
     *
     * @param root
     * @param val
     * @return
     */
        public TreeNode insertIntoBST2(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode newRoot = root;
            TreeNode pre = root;
            while (root != null) {
                pre = root;
                if (root.val > val) {
                    root = root.left;
                } else if (root.val < val) {
                    root = root.right;
                }
            }
            if (pre.val > val) {
                pre.left = new TreeNode(val);
            } else {
                pre.right = new TreeNode(val);
            }

            return newRoot;
        }
}
