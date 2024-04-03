package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 114. 二叉树展开为链表
 * @date 2024/4/3 9:03
 */
public class flatten {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;

    }

    public void flatten2(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        prederTraversal(root,list);
        int size=list.size();
        for (int i=1;i<size;i++){
            TreeNode prev=list.get(i-1),cur=list.get(i);
            prev.left=null;
            prev.right=cur;
        }

    }



    //通过前序遍历把节点存入集合中
    private void prederTraversal(TreeNode root, List<TreeNode> list) {
        if(root!=null){
            list.add(root);
            prederTraversal(root.left,list);
            prederTraversal(root.right,list);
        }
    }



    public void flatten3(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

}

