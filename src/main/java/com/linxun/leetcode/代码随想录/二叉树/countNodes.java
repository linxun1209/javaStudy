package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/1 21:31
 */
public class countNodes {
    public int countNodes(TreeNode root) {
        /**
         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
         判断左右子树的高度:
         如果相等说明左子树是满二叉树,
         然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
         如果不等说明右子树是深度小于左子树的满二叉树,
         然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
         **/
        if (root==null) {
            return 0;
        }
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if(ld == rd) {
            return (1 << ld) + countNodes(root.right);
            // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        } else {
            return (1 << rd) + countNodes(root.left);
            // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
        }

    }

    private int getDepth(TreeNode r) {
        int depth = 0;
        while(r != null) {
            depth++;
            r = r.left;
        }
        return depth;
    }


    class Solution {
        // 通用递归解法
        public int countNodes(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }



    class Solution2 {
        // 迭代法
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int result = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size -- > 0) {
                    TreeNode cur = queue.poll();
                    result++;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            return result;
        }
    }

    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {
            // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
            // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
