package com.linxun.leetcode.面试经典150题.堆;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/15 19:56
 */
public class MedianFinder {



    /*该算法使用了两个优先队列，一个是大顶堆（queMin），一个是小顶堆（queMax）。其中queMin用来保存较小的一半数据，
    queMax用来保存较大的一半数据。

    当添加一个新的数字时，在保持两个堆的大小平衡的前提下，将数字插入到相应的堆中。具体的判断逻辑如下：

    如果queMin是空的，或者新的数字num小于等于queMin的最大值，将num加入Min中。
    如果queMax的大小比queMin小1，将Min的最大值加入queMax中。
    如果queMax的大小大于queMin，将queMax的最小值加入queMin中。
    这样，通过维护两个堆的大小平衡，我们可以保证queMin的堆顶元素是较小的一半数据的最大值，queMax堆顶元素是较大的一半数据的最小值。

    当需要找到中位数时，根据不同的情况进行判断和计算：

    如果queMin的大小比queMax大，中位数就是queMin的堆顶元素。
    否则，中位数就是queMin的堆顶元素和queMax的堆顶元素的平均值。
    使用优先队列这种数据结构能够在O(logN)的时间内插入一个新元素，并且可以在O()的时间内查找中位数。
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));//大顶堆。堆顶元素是较小的一半数据的最大值
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));//小顶堆，堆顶元素是较大的一半数据的最小值
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }


    class MedianFinder2 {
        TreeMap<Integer, Integer> nums;
        int n;
        int[] left;
        int[] right;

        public MedianFinder2() {
            nums = new TreeMap<Integer, Integer>();
            n = 0;
            left = new int[2];
            right = new int[2];
        }

        public void addNum(int num) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
            if (n == 0) {
                left[0] = right[0] = num;
                left[1] = right[1] = 1;
                //奇数
            } else if ((n & 1) != 0) {
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
                //偶数
            } else {
                if (num > left[0] && num < right[0]) {
                    increase(left);
                    decrease(right);
                } else if (num >= right[0]) {
                    increase(left);
                } else {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                }
            }
            n++;
        }

        public double findMedian() {
            return (left[0] + right[0]) / 2.0;
        }

        private void increase(int[] iterator) {
            iterator[1]++;
            if (iterator[1] > nums.get(iterator[0])) {
                iterator[0] = nums.ceilingKey(iterator[0] + 1);
                iterator[1] = 1;
            }
        }

        private void decrease(int[] iterator) {
            iterator[1]--;
            if (iterator[1] == 0) {
                iterator[0] = nums.floorKey(iterator[0] - 1);
                iterator[1] = nums.get(iterator[0]);
            }
        }
    }

}

