package com.linxun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode
 * @date 2023/2/5 21:25
 */
public class permute {
    public static void main(String[] args) {

    }
    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            int[] visited = new int[nums.length];
            backtrack(res, nums, new ArrayList<Integer>(), visited);
            return res;

        }

        private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
            //数组是空的情况
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //如果等于1说明已经遍历过直接结束该循环
                if (visited[i] == 1) continue;
                visited[i] = 1;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited);
                visited[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
