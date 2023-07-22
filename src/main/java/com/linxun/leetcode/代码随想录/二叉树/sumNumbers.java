package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/5/22 23:28
 */
public class sumNumbers {
        List<Integer> path = new ArrayList<>();
        int res = 0;
        public int sumNumbers(TreeNode root) {
            // 如果节点为0，那么就返回0
            if (root == null) {
                return 0;
            }
            // 首先将根节点放到集合中
            path.add(root.val);
            // 开始递归
            recur(root);
            return res;
        }

        public void recur(TreeNode root){
            if (root.left == null && root.right == null) {
                // 当是叶子节点的时候，开始处理
                res += listToInt(path);
                return;
            }

            if (root.left != null){
                // 注意有回溯
                path.add(root.left.val);
                recur(root.left);
                path.remove(path.size() - 1);
            }
            if (root.right != null){
                // 注意有回溯
                path.add(root.right.val);
                recur(root.right);
                path.remove(path.size() - 1);
            }
            return;
        }
        public int listToInt(List<Integer> path){
            int sum = 0;
            for (Integer num:path){
                // sum * 10 表示进位
                sum = sum * 10 + num;
            }
            return sum;
        }
}
