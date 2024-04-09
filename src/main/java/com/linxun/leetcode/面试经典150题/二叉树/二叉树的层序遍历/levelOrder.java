package com.linxun.leetcode.面试经典150题.二叉树.二叉树的层序遍历;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 102. 二叉树的层序遍历
 * @date 2024/4/9 17:07
 */
public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }


    /**
     * dnf算法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }
    public void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
        //边界条件判断
        if (root == null)
            return;
        //level表示的是层数，如果level >= list.size()，说明到下一层了，所以
        //要先把下一层的list初始化，防止下面add的时候出现空指针异常
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        //level表示的是第几层，这里访问到第几层，我们就把数据加入到第几层
        list.get(level).add(root.val);
        //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }
}

