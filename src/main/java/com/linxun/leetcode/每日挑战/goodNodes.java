package com.linxun.leetcode.每日挑战;

import com.linxun.leetcode.awing每日挑战.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/25 19:05
 */
public class goodNodes {
    /**
     * 使用DFS 递归的时候，直接判断子树的节点和父节点的大小，
     * 如果子节点大，则更新rootVal，这样比较的始终是最大值，就不用额外存储最大值了
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        int ans=root.val;
        return 1+check(root.left,ans)+check(root.right,ans);

    }

    private int check(TreeNode root, int ans) {
        if(root==null){
            return 0;
        }
        if(root.val>=ans){
            return 1+check(root.left,root.val)+check(root.right,root.val);
        }else {
            return check(root.left,ans)+check(root.right,ans);
        }
    }
}
