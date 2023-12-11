package com.linxun.leetcode.hot100;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/12/11 17:56
 */
public class kthSmallest {

    /**
     * 查找左子树节点个数为leftN,如果K<=leftN,则所查找节点在左子树上.+
     * 若K=leftN+1,则所查找节点为根节点
     * 若K>leftN+1,则所查找节点在右子树上,按照同样方法查找右子树第K-leftN个节点
     * @param root
     * @param k
     * @return
     */

    public int kthSmallest(TreeNode root, int k) {
        int leftN=findChild(root.left);
        if(leftN+1==k){
            return root.val;
        } else if(k<=leftN){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right, k-leftN-1);
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



    private int result;
    private int count;
    public int kthSmallest2(TreeNode root, int k) {
        inorderTraversala(root,k);
        return result;
    }


    // 二叉搜索树中序遍历的序列是一个递增序列
    private void inorderTraversala(TreeNode root, int k) {
        if(root==null){
            return;
        }

        // 如果已经找到了，后续递归直接返回
        // 但还是会遍历完整棵树
        if(count==k){
            return;
        }
        inorderTraversala(root.left,k);
        if(++count==k){
            result=root.val;
            return;
        }
        inorderTraversala(root.right, k);
    }


    /**
     * 笨办法，中序遍历到第k个停止
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest3(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        helper(root, stack, k);
        return stack.peek();
    }
    private void helper(TreeNode root, Stack<Integer> stack, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, stack, k);
        if (stack.size() == k) {
            return;
        }
        stack.push(root.val);
        helper(root.right, stack, k);
    }
}
