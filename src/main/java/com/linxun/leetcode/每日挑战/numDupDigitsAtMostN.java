package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/20 13:11
 */
public class numDupDigitsAtMostN {


    /**
     * 基于
     */



    


    /**
     * 数学法
     * @param n
     * @return
     */
    public int numDupDigitsAtMostN(int n) {
            String sn = String.valueOf(n);
            return n + 1 - f(0, sn, 0, true);
        }

        public int f(int mask, String sn, int i, boolean same) {
            if (i == sn.length()) {
                return 1;
            }
            int t = same ? sn.charAt(i) - '0' : 9, res = 0, c = Integer.bitCount(mask) + 1;
            for (int k = 0; k <= t; k++) {
                if ((mask & (1 << k)) != 0) {
                    continue;
                }
                if (same && k == t) {
                    res += f(mask | (1 << t), sn, i + 1, true);
                } else if (mask == 0 && k == 0) {
                    res += f(0, sn, i + 1, false);
                } else {
                    res += A(sn.length() - 1 - i, 10 - c);
                }
            }
            return res;
        }

        public int A(int x, int y) {
            int res = 1;
            for (int i = 0; i < x; i++) {
                res *= y--;
            }
            return res;
        }
}
