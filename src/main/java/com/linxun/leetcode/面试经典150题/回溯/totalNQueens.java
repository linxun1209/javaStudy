package com.linxun.leetcode.面试经典150题.回溯;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * 52. N 皇后 II
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


    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }


    public int totalNQueens2(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }
}
