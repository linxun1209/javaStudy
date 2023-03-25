package com.linxun.leetcode.hot;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/25 19:36
 */
public class convertBST {
    public static void main(String[] args) {

    }


    int num = 0;


    /**
     * BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.
     * @param root
     * @return
     */
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
    /**
     * 递归写法
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root) {
        unPreOrder(root);
        return root;
    }
    public void unPreOrder(TreeNode root){
        if(root == null){
            return;
        }

        unPreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unPreOrder(root.left);
    }
    //非递归写法
    public TreeNode convertBST3(TreeNode root) {
        if(root == null){
            return root;
        }
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
            if(node.left != null){
                node = node.left;
            } else{
                node = null;
            }
        }
        return root;
    }
}
