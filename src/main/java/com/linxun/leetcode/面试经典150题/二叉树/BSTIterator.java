package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/4/7 21:24
 */
public class BSTIterator {
    TreeNode list = null;
    public BSTIterator(TreeNode root) {
        parseTree(root);
    }

    private void parseTree(TreeNode node){
        if (node.right != null){
            parseTree(node.right);
        }
        node.right = list;
        list = node;
        if (node.left != null){
            parseTree(node.left);
        }
    }

    public int next() {
        int val = list.val;
        list = list.right;
        return val;
    }

    public boolean hasNext() {
        return list != null;
    }


    private int idx;
    private List<Integer> arr;

    public void BSTIterator2(TreeNode root) {
        idx = 0;
        arr = new ArrayList<Integer>();
        inorderTraversal2(root, arr);
    }

    public int next2() {
        return arr.get(idx++);
    }

    public boolean hasNext2() {
        return idx < arr.size();
    }

    private void inorderTraversal2(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal2(root.left, arr);
        arr.add(root.val);
        inorderTraversal2(root.right, arr);
    }



    private TreeNode cur;
    private Deque<TreeNode> stack;

    public void BSTIterator3(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next3() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext3() {
        return cur != null || !stack.isEmpty();
    }



}

