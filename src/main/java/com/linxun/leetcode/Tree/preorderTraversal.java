package com.linxun.leetcode.Tree;



import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.数.二叉树的前序遍历
 * @date 2022/11/9 11:29
 *
 *
 *
 * 前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。
 *
 *
 * 中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树。
 *
 *
 * 后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点。
 * 根据不同的顺序调整代码都可以使用
 */
public class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        //先进后出
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(Integer.valueOf(node.val));
            if(node.right!=null){
               stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }
}


//递归

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);

    }
}

//迭代
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        //队列
        //先进先出
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}