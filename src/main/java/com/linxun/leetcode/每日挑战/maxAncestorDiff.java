package com.linxun.leetcode.每日挑战;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/18 12:46
 */
public class maxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        int l=maxAncestorDiff(root.left,root.val,root.val);
        int r=maxAncestorDiff(root.right,root.val,root.val);
        return l>r?l:r;
    }

    public int maxAncestorDiff(TreeNode root, int max, int min){
        if(root==null){
            return 0;
        }
        if(root.val>max){
            max=root.val;
        }
        if(root.val<min){
            min=root.val;
        }
        if(root.left==null&&root.right==null){
            return max-min;
        }
        int le=maxAncestorDiff(root.left,max,min);
        int ri=maxAncestorDiff(root.right,max,min);
        return le>ri?le:ri;
    }


    int ans = 0;
    public int maxAncestorDiff2(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, root.val, root.val);
        return ans;
    }
    public void dfs(TreeNode root, int max, int min){
        if (root == null){
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
        ans = Math.max(ans, max - min);
    }
}
