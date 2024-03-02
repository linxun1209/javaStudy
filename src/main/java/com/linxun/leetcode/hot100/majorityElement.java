package com.linxun.leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/1 22:16
 */
public class majorityElement {

    /**
     * //摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count=0;
        int m=nums[0];
        for (int i=0;i<nums.length;i++){
            if(m==nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    m=nums[i+1];
                }
            }

        }
        return m;
    }

    public int majorityElement2(int[] nums) {

        //暴力法
        Arrays.sort(nums);
        return nums[(nums.length)/2];

    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }



    class Solution {
        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        private int majorityElementRec(int[] nums, int lo, int hi) {
            // base case; the only element in an array of size 1 is the majority
            // element.
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi - lo) / 2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid + 1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length - 1);
        }
    }

}
