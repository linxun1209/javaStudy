package com.linxun.leetcode.面试经典150题.回溯;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/19 23:43
 */
public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
    }

    List<List<Integer>> resList = null;
    public List<List<Integer>> permute(int[] nums) {
        resList = new ArrayList();
        dfs(nums, 0);
        return resList;
    }

    private void dfs(int[] nums, int start){
        if(start == nums.length - 1){
            List<Integer> res = new ArrayList();
            for(int i = 0; i < nums.length; i++){
                res.add(nums[i]);
            }
            resList.add(res);
            return ;
        }

        HashSet<Integer> set = new HashSet();

        for(int i = start; i < nums.length; i++){
            if(set.add(nums[i])){
                exch(nums, start, i);
                dfs(nums, start + 1);
                exch(nums, start, i);
            }
        }
    }

    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    class Solution {
        //存放结果
        List<List<Integer>> result = new ArrayList<>();
        //暂存结果
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            boolean[] used = new boolean[nums.length];
            Arrays.fill(used, false);
            Arrays.sort(nums);
            backTrack(nums, used);
            return result;
        }

        private void backTrack(int[] nums, boolean[] used) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
                // used[i - 1] == false，说明同⼀树层nums[i - 1]未使⽤过
                // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                //如果同⼀树⽀nums[i]没使⽤过开始处理
                if (used[i] == false) {
                    used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                    path.add(nums[i]);
                    backTrack(nums, used);
                    path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                    used[i] = false;//回溯
                }
            }
        }
    }


    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
