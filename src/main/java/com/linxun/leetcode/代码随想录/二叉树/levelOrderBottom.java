package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/31 15:44
 */
public class levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode peek = que.peekFirst();
                levelList.add(que.pollFirst().val);

                if (peek.left != null) {
                    que.offerLast(peek.left);
                }
                if (peek.right != null) {
                    que.offerLast(peek.right);
                }
            }
            list.add(levelList);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i-- ) {
            result.add(list.get(i));
        }

        return result;

    }


    /**
     * 思路和模板相同, 对收集答案的方式做了优化, 最后不需要反转
     */
        public List<List<Integer>> levelOrderBottom2(TreeNode root) {
            // 利用链表可以进行 O(1) 头部插入, 这样最后答案不需要再反转
            LinkedList<List<Integer>> ans = new LinkedList<>();

            Queue<TreeNode> q = new LinkedList<>();

            if (root != null) {
                q.offer(root);
            }

            while (!q.isEmpty()) {
                int size = q.size();

                List<Integer> temp = new ArrayList<>();

                for (int i = 0; i < size; i ++) {
                    TreeNode node = q.poll();

                    temp.add(node.val);

                    if (node.left != null) {
                        q.offer(node.left);
                    }

                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }

                // 新遍历到的层插到头部, 这样就满足按照层次反序的要求
                ans.addFirst(temp);
            }

            return ans;
        }
}
