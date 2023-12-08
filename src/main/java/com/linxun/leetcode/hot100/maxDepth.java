package com.linxun.leetcode.hot100;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/21 20:08
 */
public class maxDepth {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
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

    public int maxDepthTest(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{
            add(root);
        }};
        int depth=0;
        while (!queue.isEmpty()){
            int curSize=queue.size();
            for (int i=0;i<curSize;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            depth++;
        }
        return depth;

    }
}
