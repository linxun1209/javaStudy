package com.linxun.leetcode.hot100;

import com.linxun.leetcode.代码随想录.回溯算法.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/1 22:30
 */
public class combinationSum {
    public static void main(String[] args) {
        int[] c={2,3,6,7};
        int target=7;
        combinationSum2(c,target);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backend1(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }

    private static void backend1(List<List<Integer>> res, ArrayList<Integer> path, int[] candidates, int target, int sun, int i1) {
        if(sun==target){
            res.add(new ArrayList<>(path));
        }
        for (int i=i1;i<candidates.length;i++){
            if(sun+candidates[i]>target){
                break;
            }
            path.add(candidates[i]);
            backend1(res,path,candidates,target,sun+candidates[i],i);
            path.remove(path.size()-1);
        }
    }


    /**
     * 回溯法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backend(res,new ArrayList<>(),candidates,target,0,0);
        return res;



    }

    private void backend(List<List<Integer>> res, ArrayList<Integer> path, int[] candidates, int target,int sum,int t) {
        if(sum==target){
            res.add(new ArrayList<>(path));
        }
        for (int i=t;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                break;
            }
            path.add(candidates[i]);
            backend(res,path,candidates,target,sum+candidates[i],i);
            path.remove(path.size()-1);

        }
    }
}
