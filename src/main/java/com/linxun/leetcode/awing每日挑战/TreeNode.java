package com.linxun.leetcode.awing每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.数.二叉树的前序遍历
 * @date 2022/11/9 11:35
 */
public class TreeNode {

    public int  val;
     public TreeNode left;
    public TreeNode right;
    TreeNode(){

    }
    public TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
