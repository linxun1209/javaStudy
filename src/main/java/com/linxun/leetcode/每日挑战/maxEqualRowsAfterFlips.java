package com.linxun.leetcode.每日挑战;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/15 20:38
 */
public class maxEqualRowsAfterFlips {





    public int maxEqualRowsAfterFlips(int[][] matrix) {
        //转换为求模式相同的行最大数值
        Map<String, Integer> patternMap = new HashMap<>();
        for (int[] line : matrix) {
            StringBuilder origin = new StringBuilder();
            StringBuilder convert = new StringBuilder();
            for (int row : line) {
                origin.append(row);
                convert.append((row + 1) % 2);
            }
            String o = origin.toString();
            String c = convert.toString();
            patternMap.put(o, patternMap.getOrDefault(o, 0) + 1);
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (int r : patternMap.values()) {
            ans = Math.max(ans, r);
        }
        return ans;
    }

    public int maxEqualRowsAfterFlips2(int[][] matrix) {
        //转换为求模式相同的行最大数值
        Map<String, Integer> patternMap = new HashMap<>();
        for (int[] line : matrix) {
            StringBuilder origin = new StringBuilder();
            StringBuilder convert = new StringBuilder();
            for (int row : line) {
                origin.append(row);
                convert.append((row + 1) % 2);
            }
            String o = origin.toString();
            String c = convert.toString();
            patternMap.put(o, patternMap.getOrDefault(o, 0) + 1);
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (int r : patternMap.values()) {
            ans = Math.max(ans, r);
        }
        return ans;
    }




    public int maxEqualRowsAfterFlips3(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        int p = 31;
        int[] h = new int[n];
        h[0] = 1;
        for(int i = 1;i < n;i++) {
            h[i] = p * h[i - 1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int[] ints : matrix) {
            int h1 = 0, h2 = 0;
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    h1 += h[j];
                } else {
                    h2 += h[j];
                }
            }
            map.put(h1, map.getOrDefault(h1, 0) + 1);
            map.put(h2, map.getOrDefault(h2, 0) + 1);
        }
        int res = 1;
        for(int k:map.values()) {
            res = Math.max(res,k);
        }
        return res;

    }
}
