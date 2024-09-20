package com.面试中的算法.去哪儿.去哪儿2023春招;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 19:07
 */
public class Main5 {

    public static void main(String[] args) {
        int n = 10; // 你的n值
        int[] nums = {5, 2, 7, 2, 8, 8 ,1, 5, 3, 7}; // 你的nums数组

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                set.add(nums[i]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[list.size() - i - 1] = list.get(i);
        }

        // 打印结果
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


