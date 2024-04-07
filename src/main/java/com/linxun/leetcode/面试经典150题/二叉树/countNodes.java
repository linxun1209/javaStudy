package com.linxun.leetcode.面试经典150题.二叉树;

import com.linxun.leetcode.awing每日挑战.TreeNode;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 222. 完全二叉树的节点个数
 * @date 2024/4/7 21:37
 */
public class countNodes {
    public int countNodes(TreeNode root) {
        /**
         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
         判断左右子树的高度:
         如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
         如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
         **/
        if (root==null) return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if(ld == rd) return (1 << ld) + countNodes(root.right); // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        else return (1 << rd) + countNodes(root.left);  // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量

    }

    private int getDepth(TreeNode r) {
        int depth = 0;
        while(r != null) {
            depth++;
            r = r.left;
        }
        return depth;
    }



    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }




    public int countNodes3(TreeNode root) {//计算某个点的子总数
        return count(root);
    }

    public int count(TreeNode root){
        if(root == null) return 0;
        //计算最左，最右的高度
        TreeNode node= root;
        int leftH = 0;
        int rightH=0;
        while(node!=null){
            leftH++;
            node = node.left;
        }
        while(node!=null){
            rightH++;
            node = node.right;
        }
        if(leftH == rightH){
            return (int)Math.pow(2,leftH+1)-1;
        }
        return count(root.left) + count(root.right)+1;
    }
}

