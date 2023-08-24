package com.linxun.leetcode.每日挑战;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/24 20:12
 */
public class countServers {
    /**
     * 第一次遍历记录各行的服务器数rows
     * 第二次遍历记录各列的服务器数cols
     * 第三次遍历每个服务器去判断当前行列的rows>1||cols>1即可
     * @param grid
     * @return
     */
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] rows=new int[m];
        int[] cols=new int[n];
        for (int i=0;i<m;i++){
            for (int col:grid[i]){
                if(col==1){
                    rows[i]++;
                }
            }
        }
        for (int j=0;j<n;j++){
            for (int k=0;k<m;k++){
                if(grid[k][j]==1){
                    cols[j]++;
                }
            }
        }
        int ans=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==1&&(rows[i]>1||cols[j]>1)){
                  ans++;
                }
            }
        }
        return ans;

    }

    public int countServers2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i=0;i<m;i++){
            for(int col : grid[i]){
                if(col == 1){
                    rows[i]++;
                }
            }
        }
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                if(grid[k][j] == 1){
                    cols[j]++;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 &&(rows[i]>1||cols[j]>1)){
                    ans++;
                }
            }
        }
        return ans;
    }


    /**
     * 两次遍历加哈希表
     * @param grid
     * @return
     */
    public int countServers3(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map1=new HashMap<>();
        for (int i=0;i<m;i++){
            for (int j=0;i<n;j++){
                if(grid[i][j]==1){
                    map.put(i,map.getOrDefault(i,0)+1);
                    map1.put(j,map1.getOrDefault(j,0)+1);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 &&(map.get(i)>1||map1.get(j)>1)){
                    ans++;
                }
            }
        }
        return ans;
    }

}
