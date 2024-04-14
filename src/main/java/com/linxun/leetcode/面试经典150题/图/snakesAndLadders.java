package com.linxun.leetcode.面试经典150题.图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 909. 蛇梯棋
 * @date 2024/4/12 18:04
 */
public class snakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }


    public int snakesAndLadders2(int[][] board) {
        int n = board.length;   // 获取方阵的边长
        int target = n * n;     // 获取方阵尺寸，也是最后要到达目的地
        Queue<int[]> queue = new LinkedList<>();   // 队列用于BFS，存放待搜索的方格编号和到达该方格时的最少移动数
        queue.offer(new int[]{1, 0});   // 初始{1,0}入队，表示起点1，0次移动
        boolean[][] visited = new boolean[n][n];   // 用于BFS过程中标记方格是否搜索过
        // BFS
        while(!queue.isEmpty()){
            int[] node = queue.poll();  // 弹出队首待搜索节点
            int curr = node[0], cnt = node[1];   // 获取当前搜索的方格宾浩和到达该方格的最少移动数
            cnt++;  // 移动数加1
            for(int i = curr + 1; i <= Math.min(target, curr + 6); i++){
                // 枚举所有下一个可搜索且未搜索过的方格编号
                int r = n-1 - (i-1) / n, c = (i-1) % n;     // 根据方格编号获取这个编号的行和列
                c += (n-1 - 2*c) * ((n-1-r) & 1);       // 根据行数修正列数
                if(visited[r][c])continue;  // 跳过搜索过的编号
                visited[r][c] = true;       // 标记该编号已搜索
                int next = board[r][c] == - 1 ? i : board[r][c];    // 如果这个编号所在的方格可以转移到其他格子，转移到对应编号；否则就是在当前编号
                if(next == target)return cnt;   // 到达终点，直接返回最小移动数
                queue.offer(new int[]{next, cnt});  // 加入队列
            }
        }
        return -1;  // 退出循环说明没有到达目的地
    }

}

