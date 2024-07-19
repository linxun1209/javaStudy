package com.linxun.leetcode.算法复习.二分排序;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 二分排序模板
 * @date 2024/7/19 15:21
 */
public class BinarySearchTemplate {
    // 检查x是否满足某种性质
    private static boolean check(int x) {
        return false;
    }

    // 区间[left, right]被划分成[left, mid]和[mid + 1, right]时使用：
// 或者称之为左二分查询，查找左侧第一个满足条件的数
    private static int leftBinarySearch(int[] arr, int left, int right) {
        while (left < right) {
            int mid = arr[left + right >> 1];
            if (check(mid)) {
                right = mid;    // check()判断mid是否满足性质
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 区间[left, right]被划分成[left, mid - 1]和[mid, right]时使用：
// 或者称之为右二分查询，查找右侧最后一个满足条件的数
    private static int rightBinarySearch(int[] arr, int left, int right) {
        while (left < right) {
            int mid = arr[left + right + 1 >> 1];
            if (check(mid)) {
                left = mid;    // check()判断mid是否满足性质
            } else {
                right = mid - 1;  // 有加必有减
            }
        }
        return left;
    }

}

