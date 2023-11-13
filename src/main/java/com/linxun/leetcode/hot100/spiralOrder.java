package com.linxun.leetcode.hot100;

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
}
