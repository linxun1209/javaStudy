package com.linxun.leetcode.代码随想录.图论;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.图论
 * @date 2023/5/29 17:25
 */
public class islandPerimeter {

    public int islandPerimeter2(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int res=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    res+=4;
                    if(i>0&&grid[i-1][j]==1){
                        res-=2;
                    }
                    if(j>0&&grid[i][j-1]==1){
                        res-=2;
                    }
                }

            }

        }
        return res;

    }

    public int islandPerimeter(int[][] grid) {
        //重点关注前面遍历过得方格，如果之前有相邻方格，就-2;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rsp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rsp += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        rsp -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        rsp -= 2;
                    }
                }
            }
        }
        return rsp;

    }



    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    /**
     * 迭代
     *
     * @param grid
     * @return
     */
    public int islandPerimeter3(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }


    /**
     * 深度优先遍历
     *
     * @param grid
     * @return
     */
    public int islandPerimeter4(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }
}
