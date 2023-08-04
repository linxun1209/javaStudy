package com.linxun.leetcode.hot100;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/22 13:45
 */
public class longestUnivaluePath {
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        dnf(root);
        return max;
    }
    private int dnf(TreeNode root){
        if(root.left==null&&root.right==null){
            return 0;
        }
        int leftIndex=root.left!=null?dnf(root.left)+1:0;
        int rightIndex=root.right!=null?dnf(root.right)+1:0;
        if(leftIndex>0&&root.left.val!=root.val){
            leftIndex=0;
        }
        if(rightIndex>0&&root.right.val!=root.val){
            rightIndex=0;

        }
        max=Math.max(max,leftIndex+rightIndex);
        return Math.max(leftIndex,rightIndex);


    }

}
