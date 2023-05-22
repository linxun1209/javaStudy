package com.linxun.leetcode.每日挑战;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/21 16:42
 */
public class storeWater {
    public static void main(String[] args) {
        int[] ans = {9, 0, 1};
        int[] res = {0, 2, 2};
        storeWater(ans, res);
    }


    /**
     * 贪心 + 数学
     * @param bucket
     * @param vat
     * @return
     */
    public static int storeWater(int[] bucket, int[] vat) {
        // 计算最大打水次数=最多水数/1=最多水数
        int maxCnt = Arrays.stream(vat).max().getAsInt();
        if (maxCnt == 0) {
            return 0;
        }
        // 枚举打水次数，同时看看每个需要增加多少容量达到这个次数，以及总成本多少，保留最小的成本
        int min = Integer.MAX_VALUE;
        for (int cnt = 1; cnt <= maxCnt; cnt++) {
            int totalCost = 0;
            for (int i = 0; i < bucket.length; i++) {
                int currentBucket = (vat[i] + cnt - 1) / cnt;
                int cost = currentBucket - bucket[i];
                totalCost += Math.max(cost, 0);
            }
            min = Math.min(min, totalCost + cnt);
        }
        return min;
    }


    /**
     *
     * @param bucket
     * @param vat
     * @return
     */
        public int storeWater2(int[] bucket, int[] vat) {
            int n = bucket.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (bucket[i] == 0 && vat[i] != 0) {
                    ++cnt;
                    ++bucket[i];
                }
                if (vat[i] > 0) {
                    pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
                }
            }
            if (pq.isEmpty()) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            while (cnt < res) {
                int[] arr = pq.poll();
                int v = arr[0], i = arr[1];
                res = Math.min(res, cnt + v);
                if (v == 1) {
                    break;
                }
                int t = (vat[i] + v - 2) / (v - 1);
                cnt += t - bucket[i];
                bucket[i] = t;
                pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
            }
            return res;
        }
}