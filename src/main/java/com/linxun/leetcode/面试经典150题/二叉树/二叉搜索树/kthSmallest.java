package com.linxun.leetcode.面试经典150题.二叉树.二叉搜索树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 230. 二叉搜索树中第K小的元素
 * @date 2024/4/9 18:09
 */
public class kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack=new Stack<>();
        helperTest(root,stack,k);
        return stack.peek();
    }

    private void helperTest(TreeNode root, Stack<Integer> stack, int k) {
        if(root==null){
            return;
        }
        helperTest(root.left,stack,k);
        if(stack.size()==k){
            return;
        }
        stack.push(root.val);
        helperTest(root.right,stack,k);
    }


    public int kthSmallest2(TreeNode root, int k) {
        int leftN=findChild(root.left);
        if(leftN+1==k){
            return root.val;
        } else if(k<=leftN){
            return kthSmallest2(root.left,k);
        }else {
            return kthSmallest2(root.right, k-leftN-1);
        }
    }


    /**
     *查找子节点个数
     * @param root
     * @return
     */
    public int findChild(TreeNode root) {
        if(root==null){
            return 0;
        }
        return findChild(root.left)+findChild(root.right)+1;
    }



    public int kthSmallest3(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

}

