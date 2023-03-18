package com.linxun.leetcode.代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.哈希表
 * @date 2022/10/23 17:57
 */
public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        int tep=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums1){
            for (int j:nums2){
                tep=i+j;
                if(map.containsKey(tep)){
                    map.put(tep,map.get(tep)+1);
                }else {
                    map.put(tep,1);
                }
            }
        }
        for (int i:nums3){
            for (int j:nums4){
                tep=i+j;
                if(map.containsKey(0-tep)){
                    res+=map.get(0-tep);
                }
            }
        }
        return res;
    }
}
