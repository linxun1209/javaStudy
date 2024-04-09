package com.linxun.leetcode.面试经典150题.二叉树.二叉树的层序遍历;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 637. 二叉树的层平均值
 * @date 2024/4/9 16:52
 */
public class averageOfLevels {


    /**
     * 广度优先搜索算法
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null){
            return list;
        }
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int level=deque.size();
            double ans=0.0;
            for(int i=0;i<level;i++){
                TreeNode pool = deque.pollFirst();
                ans+=pool.val;
                if(pool.left!=null){
                    deque.addLast(pool.left);
                }
                if(pool.right!=null){
                    deque.addLast(pool.right);
                }
            }
            list.add(ans/level);
        }
        return  list;
    }


    /**
     * 深度优先搜索算法
     * @param root
     * @return
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Integer> counts = new ArrayList<Integer>();
        List<Double> sums = new ArrayList<Double>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}

