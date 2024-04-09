package com.linxun.leetcode.面试经典150题.二叉树.二叉树的层序遍历;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 103. 二叉树的锯齿形层序遍历
 * @date 2024/4/9 17:20
 */
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    //层序遍历，设置一个标识，标识是否需要反序遍历某一层
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        deque.add(root);

        boolean flag = false;   //标识，为false表示不需要翻转此层
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode t = deque.poll();
                temp.add(t.val);
                if(t.left != null) deque.add(t.left);
                if(t.right != null) deque.add(t.right);
            }

            if(flag) Collections.reverse(temp);

            ans.add(temp);       //每一层遍历完就变换一次标识
            flag = !flag;
        }
        return ans;
    }
}

