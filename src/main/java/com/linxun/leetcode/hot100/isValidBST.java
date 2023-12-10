package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/15 19:33
 */

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 有效的二叉搜索树即等于中序遍历为一个递增数组
 *
 */
public class isValidBST {




    /**
     * 错误
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            isValidBST(root.left);
            ans.add(root.val);
            isValidBST(root.right);
        }
        for (int i=0;i<ans.size()-1;i++){
            if(ans.get(i)>ans.get(i+1)){
                return false;
            }

        }
        return true;
    }


    double last=-Double.MAX_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST2(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST2(root.right);
            }

        }
        return false;
    }

    public boolean isValidBST3(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public boolean isValidBST4(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            //这里把根节点和左数的所有值存进去
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 一旦左边空了,就开始弹出,如果弹出的值比
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

    TreeNode max;
    public boolean isValidBST6(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST6(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST6(root.right);
        return right;
    }

}
