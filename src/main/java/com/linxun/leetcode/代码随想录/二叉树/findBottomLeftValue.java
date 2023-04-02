package com.linxun.leetcode.代码随想录.二叉树;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/2 14:47
 */
public class findBottomLeftValue {
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) {
            findLeftValue(root.left,deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right,deep + 1);
        }
    }


    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int res=0;
        while (!queue.isEmpty()){
            int size = queue.size();;
            for (int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(i==0){
                    res=poll.val;
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }
        return res;

    }
}
