package com.linxun.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree
 * @date 2022/11/9 15:35
 */

//树的深度计算
    //迭代
//广度优先搜索
public class maxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
            res++;

        }
        return res;

    }
}

//深度优先搜索
class Solution2{
    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}