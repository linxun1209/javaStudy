package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/17 11:13
 */
public class combinationSum2 {
    /**
     * 使用标记数组
     */
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used;
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            used = new boolean[candidates.length];
            // 加标志数组，用来辅助判断同层节点是否已经遍历
            Arrays.fill(used, false);
            // 为了将重复的数字都放到一起，所以先进行排序
            Arrays.sort(candidates);
            backTracking(candidates, target, 0);
            return ans;
        }

        private void backTracking(int[] candidates, int target, int startIndex) {
            if (sum == target) {
                ans.add(new ArrayList(path));
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {
                        break;
                }
                // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                sum += candidates[i];
                path.add(candidates[i]);
                // 每个节点仅能选择一次，所以从下一位开始
                backTracking(candidates, target, i + 1);
                used[i] = false;
                sum -= candidates[i];
                path.removeLast();
            }
        }



    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum2( int[] candidates, int target ) {
            //为了将重复的数字都放到一起，所以先进行排序
            Arrays.sort( candidates );
            backTracking( candidates, target, 0 );
            return res;
        }

        private void backTracking( int[] candidates, int target, int start ) {
            if ( sum == target ) {
                res.add( new ArrayList<>( path ) );
                return;
            }
            for ( int i = start; i < candidates.length && sum + candidates[i] <= target; i++ ) {
                //正确剔除重复解的办法
                //跳过同一树层使用过的元素
                if ( i > start && candidates[i] == candidates[i - 1] ) {
                    continue;
                }

                sum += candidates[i];
                path.add( candidates[i] );
                // i+1 代表当前组内元素只选取一次
                backTracking( candidates, target, i + 1 );

                int temp = path.getLast();
                sum -= temp;
                path.removeLast();
            }
        }
    }

}
