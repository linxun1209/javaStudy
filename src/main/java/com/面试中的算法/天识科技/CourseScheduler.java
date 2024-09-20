package com.面试中的算法.天识科技;

import java.util.Arrays;

public class CourseScheduler {



    // 定义了一个 Course 类，用于存储课程的开始时间、结束时间和优先级。
    static class Course {
        int start, end, priority;
        Course(int start, int end, int priority) {
            this.start = start;
            this.end = end;
            this.priority = priority;
        }
    }

    // 使用二分查找来找到与当前课程不冲突的最后一门课程的索引。
    private static int findLastNonConflicting(Course[] courses, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (courses[mid].end <= courses[index].start) {
                if (courses[mid + 1].end <= courses[index].start) {
                    low = mid + 1;
                } else {
                    System.out.println(mid);
                    return mid;
                }
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }


    /**
     * 将课程按照结束时间排序。
     * 使用动态规划数组 dp 来存储每门课程的最大优先级之和。
     * 对于每门课程，决定是否包括它，比较包括和不包括当前课程的优先级和，取最大值。
     * @param startTimes
     * @param endTimes
     * @param priorities
     * @return
     */
    public static int maxPriority(int[] startTimes, int[] endTimes, int[] priorities) {
        int n = startTimes.length;
        Course[] courses = new Course[n];
        for (int i = 0; i < n; i++) {
            courses[i] = new Course(startTimes[i], endTimes[i], priorities[i]);
        }
        Arrays.sort(courses, (a, b) -> Integer.compare(a.end, b.end));

        int[] dp = new int[n];
        dp[0] = courses[0].priority;

        for (int i = 1; i < n; i++) {
            int includeCurrent = courses[i].priority;
            int lastNonConflicting = findLastNonConflicting(courses, i);
            if (lastNonConflicting != -1) {
                includeCurrent += dp[lastNonConflicting];
            }

            int excludeCurrent = dp[i - 1];

            dp[i] = Math.max(includeCurrent, excludeCurrent);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};
        int[] priorities = {1, 2, 3, 4, 5, 6};

        int maxPrioritySum = maxPriority(startTimes, endTimes, priorities);
        System.out.println("Maximum priority sum: " + maxPrioritySum);
    }
}
