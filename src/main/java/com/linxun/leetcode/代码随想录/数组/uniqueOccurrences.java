package com.linxun.leetcode.代码随想录.数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/19 18:42
 */
public class uniqueOccurrences {
    public boolean uniqueOccurrences1(int[] arr) {
        //        Map<Integer,Integer> map=new HashMap<>();
//        for (int i=0;i<arr.length;i++){
//            if(!map.containsKey(arr[i])){
//                map.put(arr[i],1);
//            }
//            map.getOrDefault(arr[i],map.get(arr[i])+1);
//        }
//        for ()

        Map<Integer, Integer> counter = new HashMap<>();
        for (int elem : arr) {
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        }

        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }
    public boolean uniqueOccurrences(int[] arr) {


        int[] count = new int[2002];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
            // 防止负数作为下标
        }
        boolean[] flag = new boolean[1002];
        // 标记相同频率是否重复出现
        for (int i = 0; i <= 2000; i++) {
            if (count[i] > 0) {
                if (flag[count[i]] == false) {
                    flag[count[i]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
