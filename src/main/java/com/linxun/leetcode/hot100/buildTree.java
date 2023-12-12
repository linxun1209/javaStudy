package com.linxun.leetcode.hot100;

import com.java8的新特性.Data;
import com.linxun.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/21 20:13
 */
public class buildTree {
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder==null||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        int index=0;
        for (int i=1;i<preorder.length;i++){
            //可能是左节点
            int pre=preorder[i];
            //刚开始的根节点
            TreeNode node=deque.peek();
            //如果根节点不等于可能的左节点就构建左节点，如果相等的话意味着中序遍历没有左节点
            if(node.val!=inorder[index]){
                node.left=new TreeNode(pre);
                deque.push(node.left);
            }else {
                while (!deque.isEmpty()&&deque.peek().val==inorder[index]){
                    node=deque.pop();
                    index++;
                }
                //构建右节点
                node.right=new TreeNode(pre);
                deque.push(node.right);
            }
        }
        return root;
    }


    /**
     * 递归
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        //根节点
        TreeNode root=new TreeNode (preorder[0]);
        for(int i=0;i<preorder.length;i++){
            //如果两个根节点相遇，那么中序遍历的左边是左子树，右边是右子树。以此进行遍历
            if(preorder[0]==inorder[i]){
                root.left=buildTree1(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right=buildTree1(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }

    public Map<Integer,Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            hashMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode myBuildTree(int[] preOrder,int[] inOrder,int preOrder_left,int preOrder_right,int inOrder_left,int inOrder_right ){
        if (preOrder_left > preOrder_right) {
            return null;
        }
        // 找到前序遍历根节点的值
        Integer inorder_root = hashMap.get(preOrder[preOrder_left]);
        // 建立根节点
        TreeNode treeNode = new TreeNode(preOrder[preOrder_left]);
        // 得到左子树中的数目
        int inorder_left_size = inorder_root-inOrder_left;
        treeNode.left = myBuildTree(preOrder,inOrder,preOrder_left+1,preOrder_left+inorder_left_size,inOrder_left,inorder_root-1);
        treeNode.right = myBuildTree(preOrder,inOrder,preOrder_left+inorder_left_size+1,preOrder_right,inorder_root+1,inOrder_right);
        return treeNode;
    }
    public void traversal(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode treeNode = queue.poll();
                System.out.println(treeNode.val);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
                size--;
            }
        }
    }
}
