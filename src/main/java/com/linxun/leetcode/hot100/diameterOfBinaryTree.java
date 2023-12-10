package com.linxun.leetcode.hot100;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/22 13:38
 */
public class diameterOfBinaryTree {
    int max1=0;
    public int diameterOfBinaryTree1(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs1(root);
        return max1;

    }
    private int dfs1(TreeNode root) {
        if(root.left==null&&root.right==null){
            return 0;
        }
        int leftLength=root.left==null?0:dfs1(root.left)+1;
        int rightLength=root.right==null?0:dfs1(root.right)+1;
         max1=Math.max(max1,leftLength+rightLength);
         return Math.max(leftLength,rightLength);
    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftSize = root.left == null? 0: dfs(root.left) + 1;
        int rightSize = root.right == null? 0: dfs(root.right) + 1;
        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}
