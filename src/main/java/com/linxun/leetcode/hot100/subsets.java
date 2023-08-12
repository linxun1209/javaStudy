package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/12 12:36
 */
public class subsets {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets1(nums);
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> plusNumbers = new ArrayList<>();
            for(List<Integer> result : results) {
                List<Integer> newNumber = new ArrayList<>(result);
                newNumber.add(nums[i]);
                plusNumbers.add(newNumber);
            }
            results.addAll(plusNumbers);
        }
        return results;
    }

    public List<List<Integer>> subsets2(int[] nums) {
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


    /**
     * 回溯法
     */
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backend(nums,0);
        return ans;

    }

    private void backend(int[] nums, int i) {
        ans.add(new ArrayList<>());
        if(i>=nums.length){
            return;
        }
        for (int j=i;j<nums.length;j++){
            path.add(nums[i]);
            backend(nums,i+1);
            path.removeLast();
        }
    }
}
