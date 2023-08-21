package com.linxun.leetcode.hot100;

import com.java8的新特性.Data;
import com.linxun.leetcode.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/21 20:13
 */
public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        int index=0;
        for (int i=1;i<preorder.length;i++){
            int pre=preorder[i];
            TreeNode node=deque.peek();
            //构建左节点
            if(node.val!=inorder[index]){
                node.left=new TreeNode(pre);
                deque.push(node.left);
            }else {
                //去掉根节点
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

//        int root=preorder[0];
//        int i;
//        for (i=0;i<inorder.length;i++){
//            if(inorder[i]!=root){
//                i++;
//            }
//        }
//        TreeNode node=null;
//        node.left=

    }
}
