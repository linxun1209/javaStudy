package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/22 9:55
 */
public class solveNQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens2(int n) {
        char[][] chars=new char[n][n];
        for (char[] chars1:chars){
            Arrays.fill(chars,'.');
        }
        backTrack2(n,0,chars);
        return res;
    }
    public void backTrack2(int n, int row, char[][] chessboard) {
        if(row==n){
            res.add(Array2List2(chessboard));
            return;
        }
        for (int col=0;col<n;++col){
            if(isValid2(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                backTrack2(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }
    }
    public List Array2List2(char[][] chessboard) {
        List<String> res=new ArrayList<>();
        for (char[] chars:chessboard){
            res.add(String.copyValueOf(chars));
        }
        return res;
    }
    public boolean isValid2(int row, int col, int n, char[][] chessboard) {
        for(int i=0;i<row;i++){
            if(chessboard[row][col]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0&&j<=n-1;i++,j++){
            if(chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }






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





}
