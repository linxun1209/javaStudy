package com.linxun.leetcode.代码随想录.图论;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.图论
 * @date 2023/12/13 23:40
 */
public class maxAreaOfIsland {

    /**
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 1; i < m; i++) {
            if (grid[i - 1][0] == 1 && grid[i][0] == 1) {
                uf.union((i-1)*n, i*n);
            }
        }
        for (int j = 1; j < n; j++) {
            if (grid[0][j - 1] == 1 && grid[0][j] == 1) {
                uf.union(j-1, j);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i - 1][j] == 1 && grid[i][j] == 1) {
                    uf.union((i-1)*n+j, i*n+j);
                }
                if (grid[i][j - 1] == 1 && grid[i][j] == 1) {
                    uf.union(i*n+j-1, i*n+j);
                }
            }
        }
        int max=0;
        for (int i : uf.size) {
            max=Math.max(i,max);
        }
        return max;
    }

    static class UnionFind {
        int sets;
        int[] parent;
        int[] size;
        int[] help;
        int col;
        public UnionFind(int[][] grid) {
            this.col = grid[0].length;
            sets = 0;
            int row = grid.length;
            int len = col * row;
            parent = new int[len];
            size = new int[len];
            help = new int[len];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        int index = i * col + j;
                        parent[index] = index;
                        size[index] = 1;
                        sets++;
                    }
                }
            }
        }
        public int find(int x){
            int hi=0;
            while (parent[x]!=x){
                help[hi++]=x;
                x=parent[x];
            }
            for (hi--;hi>=0;hi--){
                parent[help[hi]]=x;
            }
            return x;
        }
        public void union(int x,int y){
            int f1=find(x);
            int f2=find(y);
            if(f1!=f2){
                if(size[f1]>=size[f2]){
                    size[f1]+=size[f2];
                    parent[f2]=f1;
                }else {
                    size[f2]+=size[f1];
                    parent[f1]=f2;
                }
                sets--;
            }
        }

    }


    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs2(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs2(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }


    /**
     * 深度优先搜索 + 栈
     * @param grid
     * @return
     */
    public int maxAreaOfIsland4(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Deque<Integer> stacki = new LinkedList<Integer>();
                Deque<Integer> stackj = new LinkedList<Integer>();
                stacki.push(i);
                stackj.push(j);
                while (!stacki.isEmpty()) {
                    int cur_i = stacki.pop(), cur_j = stackj.pop();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }


    /**
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int maxAreaOfIsland5(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll(), cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }





    int count=0;
    public int maxAreaOfIsland3(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j));
                    count=0;
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!=1)
            return 0;
        count++;
        grid[i][j]=2;
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        return count;
    }

}
