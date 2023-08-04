package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/20 17:08
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        //左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
        //若左下角元素等于目标，则找到
        //若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，
        //问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
        //若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，
        //问题规模可以减小为在去掉第一列的子矩阵中寻找目标
        //若最后矩阵减小为空，则说明不存在
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
