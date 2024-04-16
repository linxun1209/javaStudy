package com.linxun.leetcode.面试经典150题.回溯;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * 51. N 皇后
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/22 9:55
 */
public class solveNQueens {
    List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col < n; ++col) {
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }


    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) {
            // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }



    List<String> tempList;
    StringBuilder sb;
    Set<Integer> lie, zhuduijiao, fuduijiao;

    public List<List<String>> solveNQueens2(int n) {
        res = new ArrayList<>();
        tempList = new ArrayList<>();
        sb = new StringBuilder();
        lie = new HashSet<>();
        zhuduijiao = new HashSet<>();
        fuduijiao = new HashSet<>();
        char[][] qipan = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                qipan[i][j] = '.'; // 初始化棋盘
            }
        }
        dfs(qipan, 0);
        return res;
    }

    public void dfs(char[][] qipan, int row) {
        if (row == qipan.length) { // 行数超过最后一行则返回。
            return;
        }
        for (int col = 0; col < qipan[0].length; col++) {
            if (lie.contains(col) || zhuduijiao.contains(row - col) || fuduijiao.contains(row + col)) { // 不能放则跳过
                continue;
            }
            qipan[row][col] = 'Q';
            for (int j = 0; j < qipan[0].length; j++) {
                if (j == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            tempList.add(sb.toString()); // 把这一行的排列方式加入list
            sb.setLength(0); // 清空StringBuilder
            lie.add(col); // 这一列不能再放棋子
            zhuduijiao.add(row - col); // 主对角线不能再放棋子
            fuduijiao.add(row + col); // 副对角线不能再放棋子
            dfs(qipan, row + 1); // 深度搜索下一行
            if (row == qipan.length - 1) { // 到达最后一行，并且棋子都安放好了
                // 将tempList深拷贝给一个新的List
                List<String> trueList = new ArrayList<>();
                for (String s : tempList) {
                    trueList.add(s);
                }
                res.add(trueList);
            }
            // 回溯 一些引用数据需要清除递归深处的调整
            lie.remove(col); // 这一列又可以放了
            zhuduijiao.remove(row - col); // 所在的主对角线又可以放了
            fuduijiao.remove(row + col); // 所在的副对角线又可以放了
            tempList.remove(tempList.size() - 1); // 清除tempList最后的元素
        }
    }


    private Boolean isValid(char[][] s, int row, int col, int n) {  //判断是否可以放
        //判断该列上是否有皇后棋子
        for (int i = 0; i < row; i++) {
            if (s[i][col] == 'Q') return false;
        }
        //判断该位置左上所有对角是否有皇后棋子
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (s[i][j] == 'Q') return false;
        }
        //判断该位置右上所有对角是否有皇后棋子
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (s[i][j] == 'Q') return false;
        }
        return true;
    }


    public List<List<String>> solveNQueens3(int n) {
        char[][] s = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = '.';
            }
        }
        backtracking(s, n, 0);
        return res;
    }

    public  void backtracking(char[][] s, int n, int row) {
        if (row == n) {
            res.add(validArray(s,n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(s, row, i, n)==false) continue;
            s[row][i] = 'Q';
            backtracking(s, n, row + 1);
            s[row][i] = '.';   //回溯
        }
    }

    //将得到符合要求的二维数组的每行所有元素用一维数组记录下来
    private  List<String> validArray(char[][] s,int n){
        List<String> temp = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<n;j++) {
                sb.append(s[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }


    public List<List<String>> solveNQueens4(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }



    public List<List<String>> solveNQueens6(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
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
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

}
