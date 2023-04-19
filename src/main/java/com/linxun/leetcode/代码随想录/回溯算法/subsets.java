package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/18 12:59
 */
public class subsets {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
        LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
        public List<List<Integer>> subsets(int[] nums) {
            subsetsHelper(nums, 0);
            return result;
        }

        private void subsetsHelper(int[] nums, int startIndex){
            result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
            if (startIndex >= nums.length){ //终止条件可不加
                return;
            }
            for (int i = startIndex; i < nums.length; i++){
                path.add(nums[i]);
                subsetsHelper(nums, i + 1);
                path.removeLast();
            }
        }
    }

}
