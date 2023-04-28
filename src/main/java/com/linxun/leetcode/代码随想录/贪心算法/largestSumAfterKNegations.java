package com.linxun.leetcode.代码随想录.贪心算法;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/4/28 22:19
 */
public class largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int k) {
        if (A.length == 1) {
            return k % 2 == 0 ? A[0] : -A[0];
        }
        Arrays.sort(A);
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (i < A.length - 1 && A[idx] < 0) {
                A[idx] = -A[idx];
                if (A[idx] >= Math.abs(A[idx + 1])) {
                    idx++;
                }
                continue;
            }
            A[idx] = -A[idx];
        }

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }


    public int largestSumAfterKNegations2(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if  (K % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();

    }



}
