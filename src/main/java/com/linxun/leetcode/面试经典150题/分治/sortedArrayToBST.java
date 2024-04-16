package com.linxun.leetcode.面试经典150题.分治;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * 108. 将有序数组转换为二叉搜索树
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/6 20:37
 */
public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        //根节点
        TreeNode root = new TreeNode(nums[m]);
        //左节点
        root.left = buildTree(nums, l, m - 1);
        //右节点
        root.right = buildTree(nums, m + 1, r);
        return root;
    }


    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        //根节点初始化
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        // 根节点入队列
        nodeQueue.offer(root);
        // 0为左区间下标初始位置
        leftQueue.offer(0);
        // nums.size() - 1为右区间下标初始位置
        rightQueue.offer(nums.length - 1);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + ((right - left) >> 1);

            // 将mid对应的元素给中间节点
            currNode.val = nums[mid];

            // 处理左区间
            if (left <= mid - 1) {
                currNode.left = new TreeNode(-1);
                nodeQueue.offer(currNode.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }

            // 处理右区间
            if (right >= mid + 1) {
                currNode.right = new TreeNode(-1);
                nodeQueue.offer(currNode.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }
        return root;
    }

}
