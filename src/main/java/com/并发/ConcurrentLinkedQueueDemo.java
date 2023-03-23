package com.并发;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/3/22 22:25
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
    }
}
