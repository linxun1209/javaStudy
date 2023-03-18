package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2022/9/5 22:38
 */


/**
 * 59. 螺旋矩阵 II
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class generateMatrix59 {

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int up = 0, down = n - 1, left = 0, right = n - 1, index = 1;
            while(index <= n * n){
                for(int i = left; i <= right; i++){
                    res[up][i] = index++;
                }
                up++;
                for(int i = up; i <= down; i++){
                    res[i][right] = index++;
                }
                right--;
                for(int i = right; i >= left; i--){
                    res[down][i] = index++;
                }
                down--;
                for(int i = down; i >= up; i--){
                    res[i][left] = index++;
                }
                left++;
            }
            return res;
        }
    }
}
