package com.linxun.leetcode.每日挑战;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/29 12:01
 */
public class numFactoredBinaryTrees {
    public static void main(String[] args) {
        int[] arr={2, 4, 5, 10};
    }
    /**
     * 贪心算法
     * @param arr
     * @return
     */
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        final long mod = 1000000007;
        HashMap<Integer,Long> map = new HashMap<>();
        for (int i : arr) map.put(i,1l);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (1l*arr[i]*arr[j]<=arr[arr.length-1]) {
                    if (map.containsKey(arr[i]*arr[j])) {
                        if (i==j) {
                            map.put(arr[i]*arr[j],(map.get(arr[i])*map.get(arr[j])+map.get(arr[i]*arr[j]))%mod);
                        }else {
                            map.put(arr[i]*arr[j],(2*map.get(arr[i])*map.get(arr[j])+map.get(arr[i]*arr[j]))%mod);
                        }
                    }
                }
            }
        }
        long rtu = 0;
        for (int i : arr) {
            rtu+=map.get(i);
            rtu%=mod;
        }
        return (int)rtu;
    }


    public int numFactoredBinaryTrees2(int[] arr) {
        int n=arr.length;
        long ans=0,Mod=(long)1e9+7;
        long[]f=new long[n];
        Arrays.sort(arr);
        Arrays.fill(f,1L);
        for(int i=0;i<n;i++){
            for(int l=0,r=i-1;l<=r;l++){
                while(l<=r&&(long)arr[l]*arr[r]>arr[i])r--;
                if(l<=r&&(long)arr[l]*arr[r]==arr[i]){
                    if(arr[r]==arr[l]){
                        f[i]=(f[i]+f[l]*f[r])%Mod;
                    }else f[i]=(f[i]+f[l]*f[r]*2)%Mod;
                }
            }
            ans=(ans+f[i])%Mod;
        }
        return (int)ans;
    }


    public int numFactoredBinaryTrees3(int[] arr) {
        //排序 + 哈希表 = 暴力     T：o(n^2)  S: o(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int n = arr.length, mod = (int)(1e9 + 7);
        long ans = 0L;
        for(int i = 0; i < n; i++) {
            map.put(arr[i], 1);
            for(int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    long res = (1L * map.get(arr[j]) * map.get(arr[i] / arr[j])) % mod;
                    res = (res + map.get(arr[i])) % mod;
                    map.put(arr[i], (int)res);
                }
            }
            ans += map.get(arr[i]);
            ans %= mod;
        }
        return (int)ans;
    }

    // 排序 + 记忆化搜索
    // 根据题中二叉树构造方式，作为因子的两个子节点若存在则一定小于根节点值(arr值均大于1，不存在自身因数情况)，
    // 所以可以将arr先排序，枚举每个数字作为根节点root，在小于root的区间内继续枚举root的合法因子对，
    // 先用哈希map存储所有数字及下标，遍历小于root的区间，对每个可整除root的因子判断商(另一个因子)是否在map内，
    // 若存在说明root可分解成这两个因子a、b，那么分别将a和b继续递归分解，而root在分解为ab的情况不同方案数为：
    // a、b各自作为根节点的方案数之积dfs(a)*dfs(b)，累加root所有分解方式的构造方案数之和即为root为根的不同树数量。

    int[] arr;
    Map<Integer, Integer> map;
    int[] cache;
    final int MOD = (int)(1e9 + 7);
    public int numFactoredBinaryTrees4(int[] arr) {
        this.arr = arr;
        Arrays.sort(arr);
        // 哈希表map存储所有数字及对应下标，方便后续可以通过一个因子找到另一个因子的值和下标。
        map = new HashMap<Integer, Integer>();
        cache = new int[arr.length];
        Arrays.fill(cache, -1);
        for(int i = 0; i < arr.length; ++i){
            map.put(arr[i], i);
        }
        int ans = 0;

        // 枚举根节点arr[i]。
        for(int i = 0; i < arr.length; ++i){
            ans = (ans + dfs(i))%MOD;
        }
        return ans;
    }
    // 返回以root为根节点的所有合法方案数。
    public int dfs(int i){
        if(cache[i] != -1){
            return cache[i];
        }
        long res = 1L;
        for(int j = i-1; j >= 0; --j){
            if(arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])){
                res = (res + (long)dfs(j) * dfs(map.get(arr[i] / arr[j]))) %MOD;
            }
        }
        return cache[i] = (int)res;
    }

}
