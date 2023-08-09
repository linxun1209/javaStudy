package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/9 18:12
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(m==0||n==0){
            return 0;
        }
        for (int i=0;i<m;i++){
            grid[i][0]+=grid[i-1][0];
        }for (int i=0;i<n;i++){
            grid[0][i]+=grid[0][i-1];
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        xiao(grid,0,0,grid.length,grid[0].length,0,list);
        Collections.sort(list);
        return list.get(0);
    }
    public void xiao(int grid[][], int i, int j, int m, int n, int sum, ArrayList<Integer> list) {
        if(i>=m||j>=n) {
            return ;
        }
        if(i==m-1&&j==n-1) {
            list.add(sum+grid[i][j]);
            return ;
        }
        sum+=grid[i][j];
        xiao(grid,i+1,j,m,n,sum,list);
        xiao(grid,i,j+1,m,n,sum,list);

    }
}
