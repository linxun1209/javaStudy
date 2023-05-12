package com.linxun.leetcode.代码随想录.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/10 22:09
 */
public class testMultiPack1 {
    public void testMultiPack1(){
        // 版本一：改变物品数量为01背包格式
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) { // 把物品展开为i
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.size(); i++) { // 遍历物品
            for(int j = bagWeight; j >= weight.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
    }

    public void testMultiPack2(){
        // 版本二：改变遍历个数
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }
}
