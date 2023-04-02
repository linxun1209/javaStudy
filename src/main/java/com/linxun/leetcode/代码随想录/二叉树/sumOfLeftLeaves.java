package com.linxun.leetcode.代码随想录.二叉树;

import com.java8的新特性.Data;
import com.linxun.leetcode.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/2 14:24
 */
public class sumOfLeftLeaves {


    /**
     * 递归
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lchild=sumOfLeftLeaves(root.left);
        int rchild=sumOfLeftLeaves(root.right);
        int ans=0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            ans=root.left.val;
        }
        int sum=ans+lchild+rchild;
        return sum;

    }


    /**
     * 迭代
     *
     */



    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                ans += node.left.val;
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

        }
        return ans;
    }



    public int sumOfLeftLeaves3(TreeNode root) {
        if(root==null){
            return 0;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offerLast(root);
        int ans=0;
        while(!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if(node.left!=null&&node.left.left==null&&node.left.right==null){
                ans+=node.left.val;
            }
            if(node.right!=null){
                deque.offerLast(node.right);
            }
            if(node.left!=null){
                deque.offerLast(node.left);
            }
        }
        return ans;
    }
}
