package com.linxun.leetcode.hot100;

import com.linxun.leetcode.awing每日挑战.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/22 20:44
 */
public class flatten {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp=root.right;
        root.left=null;
        while (root.right!=null){
            root=root.right;
        }
        root.right=temp;
    }



    public void flatten2(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        prederTraversal(root,list);
        int size=list.size();
        for (int i=0;i<size;i++){
            TreeNode prev=list.get(i-1),cur=list.get(i);
            prev.left=null;
            prev.right=cur;
        }

    }

    private void prederTraversal(TreeNode root, List<TreeNode> list) {
        if(root!=null){
            list.add(root);
            prederTraversal(root.left,list);
            prederTraversal(root.right,list);
        }
    }
}
