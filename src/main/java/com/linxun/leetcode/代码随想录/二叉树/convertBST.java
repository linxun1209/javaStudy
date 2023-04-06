package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/6 20:56
 */
public class convertBST {
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val = root.val + num;
            num = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }


    public int preNum = 0;
    //非递归写法
    public TreeNode convertBST2(TreeNode root) {
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.add(root);
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            if(node.left != null) {
                node = node.left;
            } else {
                node = null;
            }
        }
        return root;
    }
}

