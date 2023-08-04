package com.linxun.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/26 8:25
 */
public class subarraySum {
    public static void main(String[] args) {
        int[] ans={1,2,3};
        int k=3;
        subarraySum2(ans,k);
    }
    public static int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int ans=0;
        for (int i=0;i<len;i++){
            int temp=0;
            for(int j=i;j>0;j--){
                temp-=nums[j];
                if (temp==0){
                    ans++;
                }
            }
//            temp-=nums[i];
//            if(temp<0){
//                temp=k;
//                i++;
//            }
//            if(temp==0){
//                ans++;
//                temp=k;
//                i--;
//            }


        }
        return ans;
    }


    /**
     *
     */
    public static int subarraySum2(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum-k)){
                ret += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return ret;
    }


    /**
     * 枚举法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 前缀+哈希优化
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum5(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
