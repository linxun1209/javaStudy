package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/31 15:38
 *
 *
 * 层序遍历
 *
 */
public class levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }
    public void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
        //边界条件判断
        if (root == null)
            return;
        //level表示的是层数，如果level >= list.size()，说明到下一层了，所以
        //要先把下一层的list初始化，防止下面add的时候出现空指针异常
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        //level表示的是第几层，这里访问到第几层，我们就把数据加入到第几层
        list.get(level).add(root.val);
        //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }



    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {

        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (node == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }

            resList.add(itemList);
        }

    }
}
