package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> List=new ArrayList<>();
        int[][] arr=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            List<Integer> subLst=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    arr[i][j]=1;
                }else{
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
                subLst.add(arr[i][j]);
            }
            List.add(subLst);
        }
        return List;
    }


    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans=new ArrayList();
        for(int i=0;i<numRows;i++){
            List<Integer> temp=new ArrayList();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    temp.add(1);
                }else{
                    temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(temp);
        }
        return ans;

    }

    public List<List<Integer>> generate3(int numRows) {
        // 初始化动态规划数组
        Integer[][] dp = new Integer[numRows][];
        // 遍历每一行
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 每一行的第一个和最后一个元素总是 1
            dp[i][0] = dp[i][i] = 1;
            // 计算中间元素
            for (int j = 1; j < i; j++) {
                // 中间元素等于上一行的相邻两个元素之和
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        // 将动态规划数组转换为结果列表
        List<List<Integer>> result = new ArrayList<>();
        for (Integer[] row : dp) {
            result.add(Arrays.asList(row));
        }
        // 返回结果列表
        return result;
    }


    public List<List<Integer>> generate4(int numRows) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList();
            row.add(1); // the first number
            if (i == 0) {
                result.add(row);
                continue;
            }
            List<Integer> lastRow = result.get(i-1);
            for (int j = 1; j < (i+1)/2; j++) { // other symmetric numbers in the row
                int cur = lastRow.get(j - 1) + lastRow.get(j);
                row.add(j, cur);
                row.add(j, cur);
            }
            if (i > 0 && i % 2 == 0) {
                row.add(i/2, lastRow.get(i/2 - 1) + lastRow.get(i/2)); // the center number
            }
            row.add(1); // the last number
            result.add(row);
        }
        return result;

    }
}
