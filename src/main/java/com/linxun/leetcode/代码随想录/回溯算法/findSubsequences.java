package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/18 13:21
 */
public class findSubsequences {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking (int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //法二：使用map
    class Solution {
        //结果集合
        List<List<Integer>> res = new ArrayList<>();
        //路径集合
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            getSubsequences(nums,0);
            return res;
        }
        private void getSubsequences( int[] nums, int start ) {
            if(path.size()>1 ){
                res.add( new ArrayList<>(path) );
                // 注意这里不要加return，要取树上的节点
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=start ;i < nums.length ;i++){
                if(!path.isEmpty() && nums[i]< path.getLast()){
                    continue;
                }
                // 使用过了当前数字
                if ( map.getOrDefault( nums[i],0 ) >=1 ){
                    continue;
                }
                map.put(nums[i],map.getOrDefault( nums[i],0 )+1);
                path.add( nums[i] );
                getSubsequences( nums,i+1 );
                path.removeLast();
            }
        }
    }
}
