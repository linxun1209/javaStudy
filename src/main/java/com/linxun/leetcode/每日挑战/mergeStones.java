package com.linxun.leetcode.每日挑战;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/4 22:29
 */
public class mergeStones {

        // 回溯+记忆化搜索
        int[] pre;
        int k;
        int[][][] cache;
        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if((n-1) % (k-1) != 0){return -1;}
            this.k = k;
            pre = new int[n+1];
            cache = new int[n][n][k+1];
            // 初始化记忆搜索数组cache，-1标记未计算位置。
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    Arrays.fill(cache[i][j], -1);
                }
            }
            // 构造前缀和pre优化区间内和计算速度,sum[i,j] = pre[j+1]-pre[i];
            for(int i= 0; i < n; ++i){
                pre[i+1] = pre[i] + stones[i];
            }
            return dfs(0, n-1, 1);
        }
        // 递归函数[i, j]为要计算的石头堆区间，p为要合并成的堆数，
        // dfs(i,j,p)也就是将[i,j]区间内的石头堆合并成p个大堆所需要的最小代价。
        public int dfs(int i, int j, int p){
            if(cache[i][j][p] != -1){return cache[i][j][p];}
            // 若要合并成的总堆数p==1,也就是将当前区间的石头合并成一堆,
            // 等于将区间合并成k堆，再合并一次成为1堆(因为规定每次必须k堆合1)，
            // 而合并一次的代价相当于参与合并的所有堆石头数量之和。只有p==1时才能得到具体代价计算值。
            if(p == 1){
                // 递归出口：区间内只有一堆石头，不用合并，代价为0。
                if(i == j){
                    return 0;
                }
                // 显然，将p==k一次合并转移到状态p==1所需要的代价是当前区间内所有堆的石头数量之和sum(i,j)，
                // 也就是pre[j+1]-pre[i]。
                return cache[i][j][p] = dfs(i, j, k) + pre[j+1] - pre[i];
            }
            // 当p!=1时，问题dfs(i,j,p)可以划分为：在区间[i,j]内划分为 dfs(1堆)+dfs(k-1堆)的代价和。
            // 只需要枚举前面这个1堆的所有构造方式中的最小代价即可。
            int min = Integer.MAX_VALUE;
            // 枚举[i,j]区间前半部分合并成1堆石头的所有方案，取最小代价。
            // 因为前面以判断过p==1，所以此处p必然不小于2，则为保证能分成p堆，
            // 分界点m不可能取到j，否则若m取到j就相当于将整个区间合成1堆，不符合p>=2条件。
            // 并且要保证dfs(i,m,1)能成立，也就是m每次增加所得到的区间[i,m]长度一定要满足k个一组合并最后剩1堆的条件，
            // 也就是题目stones长度开始是否达标的判断条件，由于m可以取到i(此时i、m重合，区间内就一堆石头自然可以合并为1堆，
            // 代价为0，那么m之后每次后移扩充[i,m]区间都必须移动k-1个位置，
            // 才能满足每次扩张后区间仍可最终k个一组合并为1堆。因为每次合并实际消耗k-1堆。)
            for(int m = i; m < j; m+=k-1){
                min = Math.min(min, dfs(i, m, 1) + dfs(m+1, j, p-1));
            }
            // 区间[i,j]合并成p堆的最小方案就是枚举所有 前面部分1堆+后面部分p-1堆 所需要的最少代价，
            // 只需要枚举前面部分不同长度区间合并为1的所有情况，
            // 因为后面合并为p-1堆的境况都可以继续划分为dfs(...1),dfsd(...p-2)，
            // 最终回到m+1=j,也就是区间[m,j]只剩1堆的代价状态，所以递归最终一定会有出口。
            return cache[i][j][p] = min;
        }

    //记忆化搜索（二维）
    class Solution2 {
        private static final int INFINITY = 0x3f3f3f3f;
        private int[] s;
        private int[][] memory;
        private int K;
        private int[] sum;

        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            s = stones;
            memory = new int[n][n];
            K = k;
            sum = new int[n + 1];
            for (int[] m : memory) {
                Arrays.fill(m, INFINITY);
            }
            if ((n - 1) % (k - 1) != 0) {
                return -1;
            }
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + stones[i - 1];
            }
            return merge(0, n - 1);
        }

        private int merge(int i, int j) {
            int n = s.length;
            if (i == j) {
                return memory[i][j] = 0;//若最终能合并成1堆元素，则无须继续合并，成本为0；否则成本为无穷大
            }
            if (memory[i][j] != INFINITY) {
                return memory[i][j];
            }
            for (int p = i; p < j; p += K - 1) {
                memory[i][j] = Math.min(memory[i][j], merge(i, p) + merge(p + 1, j));
            }
            if ((j - i) % (K - 1) == 0) {
                memory[i][j] += sum[j + 1] - sum[i];//若[i,j]最终能合并成一堆，需要加上sum[i~j]
            }
            return memory[i][j];
        }
    }

}
