package com.linxun.leetcode.hot100;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/12/11 18:17
 */
public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        int cnt=0,tmp=0;
        TreeNode node;
        List<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            cnt=queue.size();
            while(cnt>0){
                node=queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                cnt--;
                tmp=node.val;
            }
            res.add(tmp);
        }
        return res;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();

                if (poll.left != null) {
                    que.addLast(poll.left);
                }
                if (poll.right != null) {
                    que.addLast(poll.right);
                }

                if (i == levelSize - 1) {
                    list.add(poll.val);
                }
            }
        }

        return list;
    }
}
