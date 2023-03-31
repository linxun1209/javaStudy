package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/31 15:59
 */
public class averageOfLevels {

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
                    deque.addFirst(pool.left);
                }
                if(pool.right!=null){
                    deque.addFirst(pool.right);
                }
            }
            list.add(ans/level);
        }
        return  list;

    }
}
