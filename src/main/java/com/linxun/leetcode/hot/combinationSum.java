package com.linxun.leetcode.hot;

import com.beust.ah.A;

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
