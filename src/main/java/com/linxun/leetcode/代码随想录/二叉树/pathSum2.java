package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/5/28 10:34
 */
public class pathSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> cur = new ArrayList<>();
        dfs(root, cur, 0, sum);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> cur, int sum, int target){
        if(node == null){
            return ;
        }
        if(node.left == null && node.right == null && node.val + sum == target){
            cur.add(node.val);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return ;
        }
        cur.add(node.val);
        dfs(node.left, cur, sum + node.val, target);
        dfs(node.right, cur, sum + node.val, target);
        cur.remove(cur.size() - 1);
    }
}
