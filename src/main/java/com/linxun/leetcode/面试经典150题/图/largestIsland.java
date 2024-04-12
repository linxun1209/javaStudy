package com.linxun.leetcode.面试经典150题.图;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 827. 最大人工岛
 * @date 2024/4/10 8:36
 */
public class largestIsland {
    static int[] d = {0, -1, 0, 1, 0};

    public int largestIsland(int[][] grid) {
        int n = grid.length, res = 0;
        int[][] tag = new int[n][n];
        Map<Integer, Integer> area = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = i * n + j + 1;
                    area.put(t, dfs(grid, i, j, tag, t));
                    res = Math.max(res, area.get(t));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;
                    Set<Integer> connected = new HashSet<Integer>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k], y = j + d[k + 1];
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
                            continue;
                        }
                        z += area.get(tag[x][y]);
                        connected.add(tag[x][y]);
                    }
                    res = Math.max(res, z);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int[][] tag, int t) {
        int n = grid.length, res = 1;
        tag[x][y] = t;
        for (int i = 0; i < 4; i++) {
            int x1 = x + d[i], y1 = y + d[i + 1];
            if (valid(n, x1, y1) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {
                res += dfs(grid, x1, y1, tag, t);
            }
        }
        return res;
    }

    public boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }




    public int largestIsland2(int[][] grid) {
        if (grid == null || grid.length == 0) return 1;
        int result = 0, index = 2;
        HashMap<Integer, Integer> areasMap = new HashMap();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) areasMap.put(index, calculateAreas(index++, grid, i, j)); // 只计算未编号的岛屿

        if (areasMap.size() == 0) return 1; // 没有岛屿，全是海洋
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> islands = getIslands(grid, i, j);
                    if (islands.size() == 0) continue; // 周围没有岛屿
                    result = Math.max(result,
                            islands.stream()
                                    .map(item -> areasMap.get(item))

                                    .reduce(Integer::sum)

                                    .orElse(0) + 1);
                }
            }
        }
        if (result == 0) return areasMap.get(2); // 全是岛屿，没有海洋
        return result;
    }

    public int calculateAreas(int index, int[][] grid, int row, int column) {
        if (!isLegal(grid, row, column) || grid[row][column] != 1) return 0;
        grid[row][column] = index;
        return calculateAreas(index, grid, row + 1, column) + calculateAreas(index, grid, row - 1, column) + calculateAreas(index, grid, row, column - 1) + calculateAreas(index, grid, row, column + 1) + 1;
    }

    public boolean isLegal(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public Set<Integer> getIslands(int[][] grid, int row, int column) {
        Set<Integer> result = new HashSet<>();
        if (isLegal(grid, row + 1, column) && grid[row + 1][column] != 0)
            result.add(grid[row + 1][column]);
        if (isLegal(grid, row - 1, column) && grid[row - 1][column] != 0)
            result.add(grid[row - 1][column]);
        if (isLegal(grid, row, column - 1) && grid[row][column - 1] != 0)
            result.add(grid[row][column - 1]);
        if (isLegal(grid, row, column + 1) && grid[row][column + 1] != 0)
            result.add(grid[row][column + 1]);
        return result;
    }
}

