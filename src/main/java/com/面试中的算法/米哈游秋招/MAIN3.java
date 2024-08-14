package com.面试中的算法.米哈游秋招;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description:
 * 米小游和派蒙在进行一场游戏。游戏在一个基环树（点数与边数相等的无向简单连通图）上进行，定义图中一个点的度数为与其相连的边数，
 * 二人轮流进行以下操作：
 *
 * ● 选择图中一个度数为 1 的点，删除这个点以及与这个点相连的边。
 *
 * 图中有一个特殊的点 x ，删除了点 x 的玩家即获得胜利。
 *
 * 现在，由米小游先进行操作。在双方都采取最优策略的情况下，胜者是谁？
 *
 * 输入描述
 *
 * 每个测试文件均包含多组测试数据。第一行输入一个整数 T(1<=T<=1000) 代表数据组数，每组测试数据描述如下：
 *
 * 第一行输入两个整数 n,x(3<=n<=10^5, 1<=x<=n) 表示图的点数及特殊点的编号。
 *
 * 此后 n 行，第 i 行输入两个整数 ui 和 vi (1<=vi,ui<=n ; ui!=vi) 表示树上第 i 条边连接节点 ui 和 vi 。保证图联通，没有重边。
 *
 * 除此之外，保证给定的边构成一个基环树，所有的 n 之和不超过 2*10^5 。
 *
 * 输出描述
 *
 * 对于每一组测试数据，在一行上输出胜者的名字（ Xiaoyo 或 Pyrmont ）。特别地，若点 x 不可能被删除，请输出 Draw 。
 * @date 2024/8/7 11:04
 */
public class MAIN3 {
    private static void solve() {
        int n = sc.nextInt();
        int x = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        //初始化数组
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        int[] indegre = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            indegre[a]++;
            indegre[b]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            if (indegre[i] == 1) {
                if (i == x) {
                    System.out.println("Xiaoyo");
                    return;
                }
                q.add(i);
            }
        }

        int cnt = 0;
        boolean flg = false;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            if (node == x) {
                flg = true;
                continue;
            }
            for (int next : graph.get(node)) {
                indegre[next]--;
                if (indegre[next] == 1) {
                    q.add(next);
                }
            }
        }

        if (!flg) {
            System.out.println("Draw");
        } else if (cnt % 2 == 0) {
            System.out.println("Pyrmont");
        } else {
            System.out.println("Xiaoyo");
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            solve();
        }
        sc.close();
    }
}

