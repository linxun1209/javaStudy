package com.linxun.leetcode.面试经典150题.矩阵;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 289. 生命游戏
 * @date 2024/3/12 17:21
 */
public class gameOfLife {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // 创建复制数组 copyBoard
        int[][] copyBoard = new int[rows][cols];

        // 从原数组复制一份到 copyBoard 中
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                // 规则 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }


    public void gameOfLife2(int[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }


    public void gameOfLife3(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int cnt = count_life(board, i, j);
                if (board[i][j] == 1) {
                    if (cnt == 2 || cnt == 3) board[i][j] |= (1 << 1);
                }
                else {
                    if (cnt == 3) board[i][j] |= (1 << 1);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    public int count_life(int[][] board, int x, int y) {
        int cnt = 0, n = board.length, m = board[0].length;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; ++dy) {
                if (dx == 0 && dy == 0) continue;
                int cur_x = x + dx, cur_y = y + dy;
                if (cur_x < 0 || cur_x >= n || cur_y < 0 || cur_y >= m || (board[cur_x][cur_y] & 1) == 0) continue;
                ++cnt;
            }
        }
        return cnt;
    }



    public void gameOfLife4(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只要存活就影响周围的状态
                if (board[i][j] % 10 == 1) {
                    affect(board, i, j, m, n, directions);
                }
            }
        }
        // 计算下一个状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                calculate(board, i, j);
            }
        }
    }

    private void affect(int[][] board, int x, int y, int m, int n, int[][] directions) {
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                board[newX][newY] += 10;
            }
        }
    }

    private void calculate(int[][] board, int i, int j) {
        // 计算十位上的数字即可得出周围存活cell的个数
        int value = board[i][j];
        int liveNeighbors = value / 10;
        /*
         * liveNeighbors == 3, 对应规则4
         * value % 10 == 1 是为了获取个位的数字，确认原来细胞状态是否存活，对应规则2
         */
        if (liveNeighbors == 3 || (value % 10 == 1 && liveNeighbors == 2)) {
            board[i][j] = 1; // Set to live
        } else {
            board[i][j] = 0; // Set to dead
        }
    }
}

