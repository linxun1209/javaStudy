package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/18 13:07
 */
public class subsetsWithDup {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            res.add(path);
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backend(nums,0);
        return res;



    }

    private void backend(int[] nums, int index) {
        res.add(new ArrayList<>(path));
        if(index>=nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backend(nums,i+1);
            path.removeLast();
            used[i]=false;

        }
    }

    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup( int[] nums ) {
            Arrays.sort( nums );
            subsetsWithDupHelper( nums, 0 );
            return res;
        }


        private void subsetsWithDupHelper( int[] nums, int start ) {
            res.add( new ArrayList<>( path ) );

            for ( int i = start; i < nums.length; i++ ) {
                // 跳过当前树层使用过的、相同的元素
                if ( i > start && nums[i - 1] == nums[i] ) {
                    continue;
                }
                path.add( nums[i] );
                subsetsWithDupHelper( nums, i + 1 );
                path.removeLast();
            }
        }

    }
}
