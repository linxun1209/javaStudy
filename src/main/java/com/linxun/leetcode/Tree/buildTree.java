package com.linxun.leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree
 * @date 2022/11/10 10:57
 */


//重建二叉树
    //前序遍历的第一个是根节点
public class buildTree {
    public static void main(String[] args) {
        int[] r={3,9,20,15,7};
        int[] p={9,3,15,20,7};
        int[] q={9,15,7,20,3};
//        System.out.println(buildTree(r,p));
        buildTree(p,q);


    }

    /**
     * 中序遍历和后序遍历重建
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * 根据前序遍历和中序遍历重建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> deque=new LinkedList<TreeNode>();
        deque.push(root);
        int inorderIndex=0;
        for(int i=1;i<preorder.length;i++){
            int preorderVal=preorder[i];
            TreeNode node=deque.peek();
            if(node.val!=inorder[inorderIndex]){
                node.left=new TreeNode(preorderVal);
                deque.push(node.left);
            }else{
                while(!deque.isEmpty()&&deque.peek().val==inorder[inorderIndex]){
                    node=deque.pop();
                    inorderIndex++;
                }
                node.right=new TreeNode(preorderVal);
                deque.push(node.right);
            }
        }
        return root;
    }
}
