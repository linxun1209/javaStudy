package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/12/13 23:08
 */
public class numIslands {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int sum=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    infect(grid,i,j);
                    sum++;
                }
            }
        }
        return sum;

    }

    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j]='2';
        infect(grid,i+1,j);
        infect(grid,i-1,j);
        infect(grid,i,j+1);
        infect(grid,i,j-1);
    }
}
