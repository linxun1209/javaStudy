package com.linxun.leetcode.MyQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.MyQueue
 * @date 2022/11/9 10:58
 *
 *
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。

 */
class MyCircularQueue {

    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }

    private int[] data;
    private int front, tail;
    //初始化
    public MyCircularQueue(int k) {
        data = new int[k + 1];
        front = 0;
        tail = 0;
    }
    //向循环队列插入一个元素。
    // 如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            data[tail] = value;
            tail = (tail + 1) % data.length;
            return true;
        }
    }
    //从循环队列中删除一个元素。
    // 如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % data.length;
            return true;
        }
    }
    //从队首获取元素。
    // 如果队列为空，返回 -1 。
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }
    //获取队尾元素。
    // 如果队列为空，
    // 返回 -1 。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + data.length) % data.length];
    }
    //检查循环队列是否为空。

    public boolean isEmpty() {
        return front == tail;
    }
    //检查循环队列是否为满

    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }
}