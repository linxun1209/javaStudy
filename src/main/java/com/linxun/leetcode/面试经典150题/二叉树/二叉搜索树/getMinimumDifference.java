package com.linxun.leetcode.面试经典150题.二叉树.二叉搜索树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 530. 二叉搜索树的最小绝对差
 * @date 2024/4/9 17:58
 */
public class getMinimumDifference {
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root==null)return;
        //左
        traversal(root.left);
        //中
        if(pre!=null){
            result = Math.min(result,root.val-pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }


    TreeNode pre2;
    Stack<TreeNode> stack;
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return 0;
        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left; // 左
            }else {
                cur = stack.pop();
                if (pre2 != null) { // 中
                    result = Math.min(result, cur.val - pre.val);
                }
                pre2 = cur;
                cur = cur.right; // 右
            }
        }
        return result;
    }
}

