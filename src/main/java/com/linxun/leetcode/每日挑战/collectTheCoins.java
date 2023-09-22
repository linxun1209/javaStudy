package com.linxun.leetcode.每日挑战;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/21 21:19
 */
public class collectTheCoins {

    public static void main(String[] args) {
        int[] coins={1,0,0,0,0,1};
        int[][] edge={{0,1},{1,2},{2,3},{3,4},{4,5}};

        collectTheCoins(coins,edge);
    }
    public static int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
            ++degree[x];
            ++degree[y];
        }

        int rest = n;
        /* 删除树中所有无金币的叶子节点，直到树中所有的叶子节点都是含有金币的 */
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            --degree[u];
            --rest;
            for (int v : g[u]) {
                --degree[v];
                if (degree[v] == 1 && coins[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        /* 删除树中所有的叶子节点, 连续删除2次 */
        for (int x = 0; x < 2; ++x) {
            queue = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int u = queue.poll();
                --degree[u];
                --rest;
                for (int v : g[u]) {
                    --degree[v];
                }
            }
        }

        return rest == 0 ? 0 : (rest - 1) * 2;
    }
}
