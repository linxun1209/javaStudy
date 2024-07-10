package com.linxun.leetcode.面试经典150题.分治;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 427. 建立四叉树
 * @date 2024/4/23 17:17
 */
public class construct {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    public Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
        for (int i = r0; i < r1; ++i) {
            for (int j = c0; j < c1; ++j) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }

        if (same) {
            return new Node(grid[r0][c0] == 1, true);
        }

        Node ret = new Node(
                true,
                false,
                dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }


    public Node construct2(int[][] grid) {
        int n = grid.length;
        int[][] pre = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(grid, pre, 0, 0, n, n);
    }

    public Node dfs(int[][] grid, int[][] pre, int r0, int c0, int r1, int c1) {
        int total = getSum(pre, r0, c0, r1, c1);
        if (total == 0) {
            return new Node(false, true);
        } else if (total == (r1 - r0) * (c1 - c0)) {
            return new Node(true, true);
        }

        Node ret = new Node(
                true,
                false,
                dfs(grid, pre, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, pre, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, pre, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, pre, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }

    public int getSum(int[][] pre, int r0, int c0, int r1, int c1) {
        return pre[r1][c1] - pre[r1][c0] - pre[r0][c1] + pre[r0][c0];
    }



    class Solution {
        public Node construct(int[][] grid) {
            return formNode(grid, 0, grid.length - 1, 0, grid.length - 1);
        }

        public Node formNode(int grid[][], int l, int r, int low, int high) {
            if (allSame(grid, l, r, low, high)) {
                return new Node(grid[l][low] == 1 ? true : false, true);
            }
            int mid1 = (l + r) / 2, mid2 = (low + high) / 2;
            Node topLeft = formNode(grid, l, mid1, low, mid2);
            Node topRight = formNode(grid, l, mid1, mid2 + 1, high);
            Node bottomLeft = formNode(grid, mid1 + 1, r, low, mid2);
            Node bottomRight = formNode(grid, mid1 + 1, r, mid2 + 1, high);
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }

        public boolean allSame(int grid[][], int l, int r, int low, int high) {
            //判断矩阵某区域是否同值
            for (int i = l; i <= r; i++) {
                for (int j = low; j <= high; j++) {
                    if (grid[i][j] != grid[l][low]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}

