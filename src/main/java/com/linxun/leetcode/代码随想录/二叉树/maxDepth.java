package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/31 16:46
 */
public class maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            add(root);
        }};
        int depth = 0;
        while(!queue.isEmpty()){
            int cursize = queue.size();
            for(int i = 0; i < cursize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }


    /**
     * 层序遍历的方法
     *
     */


        public int maxDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            int depth = 0;
            while (!que.isEmpty())
            {
                int len = que.size();
                while (len > 0)
                {
                    TreeNode node = que.poll();
                    if (node.left != null) {
                        que.offer(node.left);
                    }
                    if (node.right != null) {
                        que.offer(node.right);
                    }
                    len--;
                }
                depth++;
            }
            return depth;
        }
}
