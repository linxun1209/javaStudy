package com.linxun.leetcode.面试经典150题.回溯;

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
        combinationSum(c,target);
    }



    /**
     * 回溯法
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backend(res,new ArrayList<>(),candidates,target,0,0);
        return res;



    }

    private static void backend(List<List<Integer>> res, ArrayList<Integer> path, int[] candidates, int target,int sum,int t) {
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


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }
    public void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            //拷贝一份，不影响下次递归
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }
}
