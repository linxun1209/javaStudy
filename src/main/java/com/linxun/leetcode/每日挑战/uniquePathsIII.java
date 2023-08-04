package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/4 12:35
 */
public class uniquePathsIII {
    int path = 0;
    int zeroCount = 0;

    /**
     *回溯思路
     * 先找之后退出来，分别在前后左右轮着找可以到达终点的路数
     *
     *
     * 假设矩阵中有 n 个 0，那么一条合格的路径，是长度为 (n+1)
     * ，由 1起始，结束于 2，不经过 −1，
     * 且每个点只经过一次的路径。要求出所有的合格的路径，
     * 可以采用回溯法，定义函数 dfs，
     * 表示当前 grid状态下，从点 (i,j)出发，还要经过 n 个点，
     * 走到终点的路径条数。到达一个点时，如果当前的点为终点，
     * 且已经经过了 (n+1)个点，那么就构成了一条合格的路径，否
     * 则就不构成。如果当前的点不为终点，则将当前的点标记为 −1
     * ，表示这条路径以后不能再经过这个点，然后继续在这个点往四个方向扩展，
     * 如果不超过边界且下一个点的值为 0 或者 2
     * 则表示这条路径可以继续扩展。探测完四个方向后，需
     * 要将当前的点的值改为原来的值。将四个方向的合格路径求和，
     * 即为当前状态下合格路径的条数。最终需要返回的是，
     * grid 在初始状态下，从起点出发，需要经过 (n+1)
     * 个点的路径条数。

     * @param grid
     * @return
     */
    public  int uniquePathsIII(int[][] grid) {
        int rn = grid.length;
        int ln = grid[0].length;
        int indexI = -1, indexJ = -1;
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < ln; j++) {
                if (grid[i][j] == 1) {
                    indexI = i;
                    indexJ = j;
                }
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        int[][] visit = new int[rn][ln];

        findPath(grid, rn, ln, indexI, indexJ, visit, 0);
        return path;
    }


    private  void findPath(int[][] grid, int rn, int ln, int i, int j, int[][] visit, int count) {
        if (i < 0 || j < 0 || i >= rn || j >= ln || grid[i][j] == -1 || visit[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 2) {
            if (count == zeroCount) {
                path++;
            }
            return;
        }
        if (grid[i][j] == 0) {
            count++;
        }
        visit[i][j] = 1;
        // 前
        findPath(grid, rn, ln, i - 1, j, visit, count);
        // 后
        findPath(grid, rn, ln, i + 1, j, visit, count);
        // 左
        findPath(grid, rn, ln, i, j - 1, visit, count);
        // 右
        findPath(grid, rn, ln, i, j + 1, visit, count);
        if (count != 0) {
            count--;
        }
        visit[i][j] = 0;
    }
}


