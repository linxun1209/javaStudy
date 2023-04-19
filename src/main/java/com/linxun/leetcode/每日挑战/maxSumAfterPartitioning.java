package com.linxun.leetcode.每日挑战;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/19 23:06
 */
public class maxSumAfterPartitioning {

    public static void main(String[] args) {
        int[] arr={1,15,7,9,2,5,10};
        int k=3;
        maxSumAfterPartitioning5(arr,k);

    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] newArray=new int[n];
        int ans=0;
        for (int i=1;i<=n;i++){
            int max=arr[i];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {

                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                    newArray[i] = max;
                }
            }
        }
        int res=0;
        for (int i=0;i<n;i++){
            res+=newArray[i];
        }
        return res;


    }


    private Map<String, Integer> cache;

    public int maxSumAfterPartitioning2(int[] arr, int k) {
        cache = new HashMap<>();
        return dfs(arr, 0, 0, 0, k);
    }

    private int dfs(int[] arr, int i, int max, int len, int k) {
        if (i >= arr.length) {
            return max * len;
        }
        String key = i + "," + max + "," + len;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ans = max * len + dfs(arr, i + 1, arr[i], 1, k);
        if (len + 1 <= k) {
            ans = Math.max(ans, dfs(arr, i + 1, Math.max(max, arr[i]), len + 1, k));
        }
        cache.put(key, ans);
        return ans;
    }




    /*
对于数组求 最大  最小问题 一般为 动态规划问题

建立一位数组res res[i] 表示：从 0 到 位置 i 子数组的最大和

    对于每一个位置 都可能有 k 种情况：
         ①：只使用它自己位置的数字
         ②：让他保持和前面 1 个数字相同
         ........
         ⑩：让他保持和前面 k - 1 个数字相同
    转移方程：
         ①：domainMax = Math.max(domainMax, A[i - j + 1]);
            作用：求它和前面 j - 1 个数字的最大值 为保持相同的数字
         ②：res[i] = Math.max(res[i], ((i - j < 0)? 0 : res[i - j])  + j * domainMax);
            作用：求位置 i 的时候 k 种情况 的最大值
    边界条件：
         ①：i - j + 1 >= 0
            作用：保证它的前面有 j - 1 个元素
         ②：i - j < 0？
            作用：判断 当 前面恰有 j - 1 个元素 且 第 i 个位置 保持和前面 j - 1 个数字相同


*/
    public int maxSumAfterPartitioning3(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = -1;
            for (int j = i - 1; j >= Math.max(i - k, 0); j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
            }
        }
        return dp[n];
    }



    // 思路：记忆化搜索，枚举每个长度，并记忆化
    // 时间复杂度：O（nk）状态个数n*单个状态的计算时间k
    // 空间复杂度：O（n）
    int []record;
    public int maxSumAfterPartitioning4(int[] arr, int k) {
        record=new int[arr.length];
        Arrays.fill(record,-1);
        return dfs(arr,k,0);
    }
    int dfs(int[]nums,int k,int index){
        if(index>=nums.length){
            return 0;
        }
        if(record[index]!=-1){
            return record[index];
        }
        int sum=0;
        int max=nums[index];
        for(int i=index;i<index+k&&i<nums.length;i++){
            max=Math.max(max,nums[i]);
            sum=Math.max(sum,max*(i-index+1)+dfs(nums,k,i+1));
        }
        record[index]=sum;
        return sum;
    }



        public static int maxSumAfterPartitioning5(int[] arr, int k) {
            int[] dp = new int[arr.length];
            Arrays.fill(dp, -1);
            for (int i = 0; i < dp.length; i++) {
                int maxArray = arr[i];
                for (int j = i; j >= i - k + 1 && j >= 0; j--) {
                    maxArray = Math.max(maxArray, arr[j]);
                    dp[i] = Math.max(dp[i], (j - 1 >= 0 ? dp[j - 1] : 0) + maxArray * (i - j + 1));
                }
            }
            return dp[dp.length - 1];
        }
}
