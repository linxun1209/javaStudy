package com.linxun.leetcode.面试经典150题.堆;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 373. 查找和最小的 K 对数字
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * @date 2024/8/14 21:19
 */
public class kSmallestPairs {
    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 2, 11}, new int[]{2, 4, 6}, 3));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        /*二分查找第 k 小的数对和的大小*/
        int left = nums1[0] + nums2[0];
        int right = nums1[m - 1] + nums2[n - 1];
        int pairSum = right;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long cnt = 0;
            int start = 0;
            int end = n - 1;
            while (start < m && end >= 0) {
                if (nums1[start] + nums2[end] > mid) {
                    end--;
                } else {
                    cnt += end + 1;
                    start++;
                }
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                pairSum = mid;
                right = mid - 1;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        int pos = n - 1;
        /*找到小于目标值 pairSum 的数对*/
        for (int i = 0; i < m; i++) {
            while (pos >= 0 && nums1[i] + nums2[pos] >= pairSum) {
                pos--;
            }
            for (int j = 0; j <= pos && k > 0; j++, k--) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                ans.add(list);
            }
        }

        /*找到等于目标值 pairSum 的数对*/
        pos = n - 1;
        for (int i = 0; i < m && k > 0; i++) {
            int start1 = i;
            while (i < m - 1 && nums1[i] == nums1[i + 1]) {
                i++;
            }
            while (pos >= 0 && nums1[i] + nums2[pos] > pairSum) {
                pos--;
            }
            int start2 = pos;
            while (pos > 0 && nums2[pos] == nums2[pos - 1]) {
                pos--;
            }
            if (nums1[i] + nums2[pos] != pairSum) {
                continue;
            }
            int count = (int) Math.min(k, (long) (i - start1 + 1) * (start2 - pos + 1));
            for (int j = 0; j < count && k > 0; j++, k--) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[pos]);
                ans.add(list);
            }
        }
        return ans;
    }

}

