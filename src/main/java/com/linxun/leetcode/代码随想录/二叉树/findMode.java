package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/4 23:19
 */
public class findMode {

        ArrayList<Integer> resList;
        int maxCount;
        int count;
        TreeNode pre;

        public int[] findMode(TreeNode root) {
            resList = new ArrayList<>();
            maxCount = 0;
            count = 0;
            pre = null;
            findMode1(root);
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        public void findMode1(TreeNode root) {
            if (root == null) {
                return;
            }
            findMode1(root.left);

            int rootValue = root.val;
            // 计数
            if (pre == null || rootValue != pre.val) {
                count = 1;
            } else {
                count++;
            }
            // 更新结果以及maxCount
            if (count > maxCount) {
                resList.clear();
                resList.add(rootValue);
                maxCount = count;
            } else if (count == maxCount) {
                resList.add(rootValue);
            }
            pre = root;

            findMode1(root.right);
        }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            int maxCount = 0;
            int count = 0;
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur =cur.left;
                }else {
                    cur = stack.pop();
                    // 计数
                    if (pre == null || cur.val != pre.val) {
                        count = 1;
                    }else {
                        count++;
                    }
                    // 更新结果
                    if (count > maxCount) {
                        maxCount = count;
                        result.clear();
                        result.add(cur.val);
                    }else if (count == maxCount) {
                        result.add(cur.val);
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();



    }
}
