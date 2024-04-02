package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * @date 2024/4/2 22:56
 */
public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        //根节点
        TreeNode root=new TreeNode (preorder[0]);
        for(int i=0;i<preorder.length;i++){
            //如果两个根节点相遇，那么中序遍历的左边是左子树，右边是右子树。以此进行遍历
            if(preorder[0]==inorder[i]){
                root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }




    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder==null||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        int index=0;
        for (int i=1;i<preorder.length;i++){
            //可能是左节点
            int pre=preorder[i];
            //刚开始的根节点
            TreeNode node=deque.peek();
            //如果根节点不等于可能的左节点就构建左节点，如果相等的话意味着中序遍历没有左节点
            if(node.val!=inorder[index]){
                node.left=new TreeNode(pre);
                deque.push(node.left);
            }else {
                while (!deque.isEmpty()&&deque.peek().val==inorder[index]){
                    node=deque.pop();
                    index++;
                }
                //构建右节点
                node.right=new TreeNode(pre);
                deque.push(node.right);
            }
        }
        return root;
    }
}

