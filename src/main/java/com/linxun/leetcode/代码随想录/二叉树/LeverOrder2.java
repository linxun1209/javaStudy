package com.linxun.leetcode.代码随想录.二叉树;



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/31 16:16
 */
public class LeverOrder2 {
    /**
     * 解法1：队列，迭代。
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Node> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node poll = que.pollFirst();

                levelList.add(poll.val);

                List<Node> children = poll.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        que.offerLast(child);
                    }
                }
            }
            list.add(levelList);
        }

        return list;
    }
}
 class Node {
    public int val;
    public List<Node> children;
    public Node(){

    }
    public Node (int val){
        val=this.val;
    }
    public Node(int val,List<Node> children){
        val=this.val;
        children=this.children;
    }
}


