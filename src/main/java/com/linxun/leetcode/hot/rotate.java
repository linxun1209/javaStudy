package com.linxun.leetcode.hot;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/3 13:15
 */
public class rotate {
    /**
     * 先转置再镜像
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<=i;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;i<matrix.length/2;j++){
                int temp=matrix[i][matrix.length-i-j];
                matrix[i][matrix.length-i-j]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tem=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=tem;

            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int tem=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=matrix[i][j];
                matrix[i][j]=tem;


            }
        }
    }
}
