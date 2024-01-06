package com.linxun.leetcode.hot100;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2024/1/6 9:49
 */
public class MedianFinder {


    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;
    public MedianFinder() {
        queueMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queueMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    /**
     * 优先队列
     * @param num
     */
    public void addNum(int num) {
        if(queueMin.isEmpty()||num<=queueMin.peek()){
            queueMin.offer(num);
            if(queueMax.size()+1<queueMin.size()){
                queueMax.offer(queueMin.poll());
            }
        }else {
            queueMax.offer(num);
            if(queueMax.size()>queueMin.size()){
                queueMin.offer(queueMax.poll());
            }
        }

    }

    public double findMedian() {
        if(queueMin.size()>queueMax.size()){
            return queueMin.size();
        }
        return (queueMin.peek()+queueMax.peek())/2.0;
    }



    //有序集合 + 双指针

    TreeMap<Integer, Integer> nums;
    int n;
    int[] left;
    int[] right;

    public void MedianFinder2() {
        nums = new TreeMap<Integer, Integer>();
        n = 0;
        left = new int[2];
        right = new int[2];
    }

    public void addNum2(int num) {
        nums.put(num, nums.getOrDefault(num, 0) + 1);
        if (n == 0) {
            left[0] = right[0] = num;
            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {
            if (num < left[0]) {
                decrease(left);
            } else {
                increase(right);
            }
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

    public double findMedian2() {
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
