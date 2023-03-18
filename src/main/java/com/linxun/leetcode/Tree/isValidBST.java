package com.linxun.leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree.二叉搜索树
 * @date 2022/11/18 12:41
 */


public class isValidBST {
}
class Solution7 {
    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            //这里把根节点和左数的所有值存进去
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
//            一旦左边空了,就开始弹出,如果弹出的值比
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}