package com.linxun.leetcode.每日挑战;

import com.linxun.leetcode.Tree.TreeNode;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/25 21:28
 */
public class bstToGst {
    int num=0;
    public TreeNode bstToGst(TreeNode root) {

        if (root != null) {
            //遍历右子树
            bstToGst(root.right);
            //遍历顶点
            root.val = root.val + num;
            num = root.val;
            //遍历左子树
            bstToGst(root.left);
            return root;
        }
        return null;
    }
}
