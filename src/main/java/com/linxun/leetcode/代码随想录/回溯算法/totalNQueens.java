package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/5/29 15:38
 */
public class totalNQueens {
    class Solution {
        int ans=0;
        public int totalNQueens(int n) {
            char[][] boards=new char[n][n];
            for (char[] chars:boards){
                Arrays.fill(boards,'.');
            }
            backTrack(n,0,boards);
            return ans;


        }

        private void backTrack(int n, int row, char[][] board) {
            if(row==n){
                ans++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isValid(row, col, n, board)) {
                    board[row][col] = 'Q';
                    backTrack(n, row + 1, board);
                    board[row][col] = '.';
                }
            }
        }
        private boolean isValid(int row, int col, int n, char[][] board) {
            // 检查列
            for (int i = 0; i < row; ++i) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            // 检查45度对角线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            // 检查135度对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
}
