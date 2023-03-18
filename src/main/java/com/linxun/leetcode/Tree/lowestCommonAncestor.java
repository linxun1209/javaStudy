package com.linxun.leetcode.Tree;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree
 * @date 2022/11/10 17:07
 */
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        if(p.val<root.val&&q.val<root.val){
            lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val&&q.val>root.val){
            lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
        return null;
    }
}


class Solution6 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }

        return null;
    }
}