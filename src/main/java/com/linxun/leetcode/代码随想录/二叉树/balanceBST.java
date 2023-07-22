package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/5/28 11:56
 */
public class balanceBST {
    ArrayList<Integer> res=new ArrayList<>();
    private void travesal(TreeNode cur){
        if(cur==null){
            return;
        }
        travesal(cur.left);
        res.add(cur.val);
        travesal(cur.right);
    }
    private TreeNode getTree(ArrayList<Integer> nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums.get(mid));
        root.left=getTree(nums,left,mid-1);
        root.right=getTree(nums,mid+1,right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        travesal(root);
        return getTree(res, 0, res.size() - 1);
    }
}
