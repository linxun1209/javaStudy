package com.linxun.leetcode.hot100;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/22 13:41
 */
public class maxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 和上题唯一的区别在这里，如果左右孩子的结果是负数的话就舍弃。
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        max = Math.max(max, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }

    int Max=Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        maxGain(root);
        return Max;
    }
    public int maxGain(TreeNode root0){
        if(root0==null){
            return 0;
        }
        int left=Math.max(maxGain(root0.left),0);
        int right=Math.max(maxGain(root0.right),0);
        int priceNewPath=root0.val+left+right;
        max=Math.max(max,priceNewPath);
        return root0.val+Math.max(left,right);
    }


    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum3(TreeNode root) {
        maxGain2(root);
        return maxSum;
    }

    public int maxGain2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}

