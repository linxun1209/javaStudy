package com.linxun.leetcode.面试经典150题.回溯;

/**
 * @author xingchen
 * @version V1.0
 * 79. 单词搜索
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/13 8:26
 */
public class exist {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(searchExit(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean searchExit(char[][] board, String word, int i, int j, int i1) {
        if(word.length()<=i1){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(i1)){
            return false;
        }
        board[i][j]+=256;
        boolean b = searchExit(board, word, i - 1, j, i1 + 1)
                || searchExit(board, word, i + 1, j, i1 + 1)
                || searchExit(board, word, i, j - 1, i1+1)
                || searchExit(board, word, i, j + 1, i1 + 1);
        board[i][j]-=256;
        return b;
    }

    public boolean exist2(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
