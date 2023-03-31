package com.linxun.leetcode.代码随想录.二叉树;

import com.java8的新特性.Data;
import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/31 16:23
 */
public class largestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return list;
        }
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                max = max < node.val ? node.val : max;
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            // list中添加本层最大节点值max。
            list.add(max);
        }
        return list;
    }
}
