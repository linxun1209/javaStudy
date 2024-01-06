package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/17 20:15
 */
public class findKthLargest {
    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        int k=2;
        findKthLargest4(nums,k);
    }


    public static int findKthLargest2(int[] nums, int k) {
        int max=nums[0],min=nums[0];
        for (int num:nums){
            if(max<num){
                max=num;
            }else {
                min=num;
            }
        }
        int[] count =new int[max-min+1];
        for (int num:nums){
            count[num-min]++;
        }
        for (int i=max-min;i>=0;i--){
            k-=count[i];
            if(k<=0){
                return i+min;
            }
        }
        return nums[0];
    }



    public static int findKthLargest(int[] nums, int k) {
        //找到最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        //根据最大值和最小值确定计数范围
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        //寻找第k大的数字
        for (int i = max - min; i >= 0; i--) {
            k -= count[i];
            if (k <= 0) {
                return i + min;
            }
        }
        return nums[0];
    }


    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k)
            return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }

    public int findKthLargest3(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }




    static int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }
    public static int findKthLargest4(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }

}
