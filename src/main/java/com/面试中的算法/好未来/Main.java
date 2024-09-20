package com.面试中的算法.好未来;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/10 18:25
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */

    public int sumOfUnique (int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int sum=0;
        for(int i:map.keySet()){
            if(map.get(i)==1){
                sum+=i;
            }
        }
        return sum;





    }
    public int sumOfUnique1 (int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                i++;
            }
            sum+=nums[i-1];
        }
        return sum;
        // write code here
    }
}

