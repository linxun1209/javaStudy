package com.linxun.leetcode;

import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode
 * @date 2023/3/31 16:18
 */
public class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;



    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val,Node random) {
        val = _val;
        random=random;
    }
}