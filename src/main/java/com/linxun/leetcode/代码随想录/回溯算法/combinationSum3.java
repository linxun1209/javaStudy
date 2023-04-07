package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/7 13:22
 */
public class combinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));

            }
            return;

        }
        for (int i=startIndex;i<=i-(result.size())+1;i++){
            path.add(i);
            sum+=i;
            backTracking(targetSum,k,i+1,sum);
            path.removeLast();
            sum-=i;
        }

    }


    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            res.clear();
            list.clear();
            backtracking(k, n, 9);
            return res;
        }

        private void backtracking(int k, int n, int maxNum) {
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(list));
                return;
            }

            // 因为不能重复，并且单个数字最大值是maxNum，所以sum最大值为
            // （maxNum + (maxNum - 1) + ... + (maxNum - k + 1)） == k * maxNum - k*(k - 1) / 2
            if (maxNum == 0
                    || n > k * maxNum - k * (k - 1) / 2
                    || n < (1 + k) * k / 2) {
                return;
            }
            list.add(maxNum);
            backtracking(k - 1, n - maxNum, maxNum - 1);
            list.remove(list.size() - 1);
            backtracking(k, n, maxNum - 1);
        }

    }
}
