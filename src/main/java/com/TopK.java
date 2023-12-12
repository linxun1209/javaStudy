package com;

import java.util.PriorityQueue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com
 * @date 2023/12/12 23:23
 */
public class TopK {
    public static void main(String[] args) {
        // 定义模拟数据
        int[] nums = {3, 5, 1, 7, 8, 2, 9, 4, 6};
        // 定义需要找的top k
        int k = 3;
        // 拿到top k数组
        int[] result = topK(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * top-k算法(最小堆实现)
     * @author: yudan
     */
    public static int[] topK(int[] nums, int k) {
        // 定义优先队列充当最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        // 遍历数组
        for (int num : nums) {
            if (queue.size() < k) {
                // 保证堆中永远都有且只有k个元素
                queue.offer(num);
            } else {
                // 与堆顶元素比较进行更换
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        // 出队将结果放入数组中返回

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}