package com.linxun.leetcode.每日挑战;

import com.linxun.leetcode.awing每日挑战.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/6 12:25
 */
public class lcaDeepestLeaves {
    int deep=-1;
    TreeNode result=null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lcaDeepestLeaves(root,0);
        return result;
    }

   public int lcaDeepestLeaves(TreeNode root,int d){
        if(root.left==null&&root.right==null){
            if(d>deep){
                result=root;
                deep=d;
            }
            return d;
        }
        lcaDeepestLeaves(root.left,d+1);
        lcaDeepestLeaves(root.right,d+1);
        int l=lcaDeepestLeaves(root.left,d+1),r=lcaDeepestLeaves(root.right,d+1);
        if(l==deep&&r==deep){
            result=root;

        }
        return Math.max(l,r);

   }


    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        return dfs(root, 0, getDepth(root));
    }

    private int getDepth(TreeNode node) {
        return node == null ? -1 : Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    private TreeNode dfs(TreeNode node, int depth, int maxDepth) {
        if (node == null) return null;
        if (depth++ == maxDepth) return node;
        TreeNode l = dfs(node.left, depth, maxDepth), r = dfs(node.right, depth, maxDepth);
        return l != null && r != null ? node : (l != null ? l : r);
    }
}
