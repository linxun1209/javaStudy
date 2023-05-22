package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/2 15:06
 */
public class pathsum {
    public List<List<Integer>> pathsum(TreeNode root, int targetsum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
            // 非空判断
        }

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetsum, res, path);
        return res;
    }

    public void preorderdfs(TreeNode root, int targetsum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetsum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetsum，返回
        }

        if (root.left != null) {
            preorderdfs(root.left, targetsum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            preorderdfs(root.right, targetsum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
    }


    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum (TreeNode root,int targetSum) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        travesal(root, targetSum);
        return result;
    }
    private void travesal(TreeNode root,  int count) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0) {
            result.add(new LinkedList<>(path));
        }
        travesal(root.left, count);
        travesal(root.right, count);
        path.removeLast(); // 回溯
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
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
