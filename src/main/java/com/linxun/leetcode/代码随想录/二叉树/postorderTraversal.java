package com.linxun.leetcode.代码随想录.二叉树;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/3/30 20:40
 */

import com.linxun.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * 后序遍历
 *
 */
public class postorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);

    }


//    TreeNode p = root,r = null;
//    List<Integer>ans = new ArrayList();
//    Deque<TreeNode> s = new ArrayDeque();
//        while(!s.isEmpty() || p != null)
//    {
//        if(p != null)
//        {
//            s.push(p);
//            p = p.left;
//        }
//        else
//        {
//            p = s.peek();
//            if(p.right == null || p.right == r)
//            {
//                ans.add(p.val);
//                r = p;
//                s.pop();
//                p = null;
//            }
//            else
//                p = p.right;
//
//        }
//
//    }
//
//        return ans;
//}


    /**
     * 栈实现的非递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode p = null;//用来记录上一节点
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
//            后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。
//            所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
//            如果是从右边再返回根结点，应该回到上层。
            //主要就是判断出来的是不是右子树，是的话就可以把根节点=加入到list了
            if(cur.right == null || cur.right == p){
                list.add(cur.val);
                stack.pop();
                p = cur;
                cur = null;
            }else{
                cur = cur.right;
            }

        }
        return list;
    }
}
