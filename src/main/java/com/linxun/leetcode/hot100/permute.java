package com.linxun.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/3 13:00
 */
public class permute {



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int[] visited = new int[nums.length];
        backend(res,new ArrayList<>(),nums,visited);
        return res;
     }

    private void backend(List<List<Integer>> res, ArrayList<Integer> es, int[] nums, int[] visited) {
        if(nums.length==es.size()){
            res.add(new ArrayList<>(es));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (visited[i]==1){
                continue;
            }
            visited[i]=1;
            es.add(nums[i]);
            backend(res,es,nums,visited);
            visited[i]=0;
            es.remove(es.size()-1);
        }
    }



    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        dfs(res, nums, list);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.addLast(nums[i]);
            dfs(res, nums, list);
            list.removeLast();
        }
    }

}
