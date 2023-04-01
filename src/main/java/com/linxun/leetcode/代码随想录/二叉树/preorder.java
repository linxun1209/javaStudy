package com.linxun.leetcode.代码随想录.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/1 20:53
 */
public class preorder {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        //递归版

        if(root == null) {
            return res;
        }
        res.add(root.val);
        for(Node child:root.children)
        {
            preorder(child);
        }

        return res;
    }

    public List<Integer> preorder2(Node root) {
        /**
         * 非递归版
         */
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if(root == null) {
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            res.add (node.val);
            for(int i =  node.children.size()-1;i>= 0;i--)
            {
                stack.add(node.children.get(i));
            }
        }
        return res;
    }
}
