package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/11/13 16:17
 *
 * 矩阵第二题
 * 螺旋矩阵
 *
 */
public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null||matrix[0].length==0){
            return new LinkedList<>();
        }
        int l=0;
        int r=matrix[0].length-1;
        int u=0;
        int d=matrix.length-1;
        List<Integer> res=new LinkedList<>();
        while (l<=r&&u<=d){
            for (int i=l;i<=r;i++){
                res.add(matrix[u][i]);
            }
            u++;
            for (int i=u;u<=d;i++){
                res.add(matrix[i][r]);
            }
            r--;
            for (int i=r;i>=l&&u<=d;i--){
                res.add(matrix[d][i]);
            }
            d--;
            for (int i=d;i>=u&&l<=r;i--){
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
