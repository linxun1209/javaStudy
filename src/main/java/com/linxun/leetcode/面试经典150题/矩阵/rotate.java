package com.linxun.leetcode.面试经典150题.矩阵;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 48. 旋转图像
 * @date 2024/3/12 16:52
 */
public class rotate {
    public void rotate(int[][] matrix) {

        //先转置
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tem=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=tem;

            }
        }
        //在对称
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int tem=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=matrix[i][j];
                matrix[i][j]=tem;
            }
        }
    }


    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }


    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}

