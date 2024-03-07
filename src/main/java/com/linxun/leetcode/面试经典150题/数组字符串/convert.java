package com.linxun.leetcode.面试经典150题.数组字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 6. Z 字形变换
 * @date 2024/3/7 9:09
 */
public class convert {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        List<StringBuilder> stringBuilderList=new ArrayList<StringBuilder>();
        for(int i=0;i<numRows;i++){
            stringBuilderList.add(new StringBuilder());
        }
        int i=0,flag=-1;
        for(char c:s.toCharArray()){
            stringBuilderList.get(i).append(c);
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (StringBuilder builder:stringBuilderList){
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();

    }


    public String convert2(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public String convert3(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[r];
        for (int i = 0; i < r; ++i) {
            mat[i] = new StringBuffer();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }

}

