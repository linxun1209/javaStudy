package com.linxun.leetcode.算法复习.链表的学习;
/**
 * @description: 双向链表的定义以及方法
 * @author xing'chen
 * @date 2024/7/22 14:24
 * @version 1.0
 */
public class DoublyLinkList {
    private DoubleNode first;
    private DoubleNode last;
    public DoublyLinkList() {
        first = null;
        last = first;
    }
    //从头部开始打印
    public void displayForward() {
        System.out.print("List(first--->last): ");
        DoubleNode current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    //从尾部开始演绎
    public void displayBackward() {
        System.out.print("List(last--->first): ");
        DoubleNode current = last;
        while (current != null) {
            current.displayNode();
            current = current.prev;
        }
        System.out.println();
    }



    //头部插入
    public void insertFirst(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (first == null) {
            last = newDoubleNode;
        } else {//如果不是第一个结点的情况
            //将还没插入新结点之前链表的第一个结点的previous指向newNode
            first.prev = newDoubleNode;
        }
        newDoubleNode.next = first;
        //将新结点赋给first（链接）成为第一个结点
        first = newDoubleNode;
    }
    //尾部插入
    public void insertLast(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (first == null) {
            first = newDoubleNode;
        } else {
            newDoubleNode.prev = last;
            last.next = newDoubleNode;
        }
        //由于插入了一个新的结点，又因为是尾部插入，所以将last指向newNode
        last = newDoubleNode;
    }


    public void insertAfter(int key, int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        DoubleNode current = first;
        while ((current != null) && (current.data != key)) {
            current = current.next;
        }
        //若当前结点current为空
        if (current == null) {
            if (first == null) {
                first = newDoubleNode;
                last = newDoubleNode;
            } else {
                //2、找不到key值，则在链表尾部插入一个新的结点
                last.next = newDoubleNode;
                newDoubleNode.prev = last;
                last = newDoubleNode;
            }
        } else {//第3种情况，找到了key值，分两种情况
            if (current == last) {
                //1、key值与最后结点的data相等
                newDoubleNode.next = null;
                last = newDoubleNode;
            } else {
                //2、两结点中间插入
                newDoubleNode.next = current.next;
                current.next.prev = newDoubleNode;
            }
            current.next = newDoubleNode;
            newDoubleNode.prev = current;
        }
    }


    //删除首元素
    public DoubleNode deleteFirst() {
        DoubleNode temp = first;
        //若链表只有一个结点，删除后链表为空，将last指向null
        if (first.next == null) {
            last = null;
        } else {
            //若链表有两个及以上的结点 ，因为是头部删除，则first.next将变成第一个结点，其previous将变成null
            first.next.prev = null;
        }
        //将first.next赋给first
        first = first.next;
        //返回删除的结点
        return temp;
    }

    //从尾部删除结点
    public DoubleNode deleteLast() {
        DoubleNode temp = last;
        //如果链表只有一个结点，则删除以后为空表,last指向null
        if (first.next == null) {
            first = null;
        } else {
            //将上一个结点的next域指向null
            last.prev.next = null;
        }
        //上一个结点称为最后一个结点，last指向它
        last = last.prev;
        //返回删除的结点
        return temp;
    }


    public DoubleNode deleteKey(int key) {
        DoubleNode current = first;
        //遍历链表寻找该值所在的结点
        while (current != null && current.data != key) {
            current = current.next;
        }
        //若当前结点指向null则返回null，
        if (current == null) {
            return null;
        } else {
            //如果current是第一个结点
            if (current == first) {
                //则将first指向它，将该结点的previous指向null,其余不变
                first = current.next;
                current.next.prev = null;
            } else if (current == last) {
                //如果current是最后一个结点
                last = current.prev;
                current.prev.next = null;
            } else {
                //当前结点的上一个结点的next域应指向当前的下一个结点
                current.prev.next = current.next;
                //当前结点的下一个结点的previous域应指向当前结点的上一个结点
                current.next.prev = current.prev;
            }
        }
        return current;        //返回
    }

}

