package com.linxun.leetcode.算法复习.链表的学习;

class DoubleNode {
    public int data;    //数据域
    public DoubleNode next;    //指向下一个结点
    public DoubleNode prev;    //指向上一个结点
    public DoubleNode(int data) {
        this.data = data;
    }
    //打印结点的数据域
    public void displayNode() {
        System.out.print("{" + data + "} ");
    }
}
