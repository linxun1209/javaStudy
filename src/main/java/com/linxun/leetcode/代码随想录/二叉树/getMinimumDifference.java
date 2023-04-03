package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/3 13:12
 */
public class getMinimumDifference {
    TreeNode pre;
    int min=Integer.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        travel(root);
        return min;

    }

    private void travel(TreeNode root) {
        if(root==null){
            return;
        }
        travel(root.left);
        if(pre!=null){
            min=Math.min(min,root.left.val-pre.val);
        }
        pre=root;
        travel(root.right);

    }


//    TreeNode pre;
//    Stack<TreeNode> stack;
//    public int getMinimumDifference(TreeNode root) {
//        if (root == null) return 0;
//        stack = new Stack<>();
//        TreeNode cur = root;
//        int result = Integer.MAX_VALUE;
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                stack.push(cur); // 将访问的节点放进栈
//                cur = cur.left; // 左
//            }else {
//                cur = stack.pop();
//                if (pre != null) { // 中
//                    result = Math.min(result, cur.val - pre.val);
//                }
//                pre = cur;
//                cur = cur.right; // 右
//            }
//        }
//        return result;
//    }
}
