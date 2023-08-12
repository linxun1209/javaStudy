package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/12 11:59
 */
import java.util.*;

/**
 * 问大家一个算法题：
 * 假设有一颗树，每个节点都有一个权值，当两个节点权值乘积为完全平方数，
 * 并且两个节点都为白色时，可以将两个节点都染红，求最多可以染红多少个节点
 * 输入：
 * 第一行一个整数 代码总的节点数目
 * 第二行n个数，代表每个数的权值
 * 之后n-1行，每行两个整数，代表两个节点之间有边相连
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int maxNodes = 0;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 节点数目
        int[] weights = new int[n + 1];
        List<Integer>[] edges = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            weights[i] = scanner.nextInt();
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, visited, weights, edges);
        System.out.println(maxNodes);
    }

    static void dfs(int node, boolean[] visited, int[] weights, List<Integer>[] edges) {
        visited[node] = true;

        for (int neighbor : edges[node]) {
            if (!visited[neighbor]) {
                if (isSquareNumber(weights[node] * weights[neighbor])) {
                    maxNodes += 2;  // 染红两个节点
                    dfs(neighbor, visited, weights, edges);
                }
                else {
                    dfs(neighbor, visited, weights, edges);
                }
            }
        }
    }




    static boolean isSquareNumber(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt == Math.floor(sqrt);
    }
}