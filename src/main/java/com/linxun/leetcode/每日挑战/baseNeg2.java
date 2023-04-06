package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/6 21:01
 */
public class baseNeg2 {


    /**
     * 思路
     *基本思路：2的偶数次方可以直接靠某二进制位凑出来，
     * 但是2的奇数次方需要这一位和左边一位一正一负凑出来，
     * 因此凡是遇到奇数次方二进制位为1时（也就是这一位在二进制代表为1<<j），
     * 需要在此留下1，同时在原数加上(1<<(j+1))，
     * 之后去掉这一位，保证数字大小平衡，继续按照二进制处理
     *
     *
     * @param n
     * @return
     */
        public String baseNeg2(int n) {
            if(n==0){return "0";}
            String ans="";
            for(int i=0;n>0;i++){
                ans=(n&1)+ans;
                if((i&1)==1){n+=(n&1)<<1;}
                n>>=1;
            }
            return ans;
        }


    /**
     * 模拟
     *
     */
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            int[] bits = new int[32];
            for (int i = 0; i < 32 && n != 0; i++) {
                if ((n & 1) != 0) {
                    bits[i]++;
                    if ((i & 1) != 0) {
                        bits[i + 1]++;
                    }
                }
                n >>= 1;
            }
            int carry = 0;
            for (int i = 0; i < 32; i++) {
                int val = carry + bits[i];
                bits[i] = val & 1;
                carry = (val - bits[i]) / (-2);
            }
            int pos = 31;
            StringBuilder res = new StringBuilder();
            while (pos >= 0 && bits[pos] == 0) {
                pos--;
            }
            while (pos >= 0) {
                res.append(bits[pos]);
                pos--;
            }
            return res.toString();
        }
    }


    /**
     * 进制转化
     *
     */

    class Solution2 {
        public String baseNeg2(int n) {
            if (n == 0 || n == 1) {
                return String.valueOf(n);
            }
            StringBuilder res = new StringBuilder();
            while (n != 0) {
                int remainder = n & 1;
                res.append(remainder);
                n -= remainder;
                n /= -2;
            }
            return res.reverse().toString();
        }
    }


    /**
     * 数学方法
     *
     */
    class Solution3 {
        public String baseNeg2(int n) {
            int val = 0x55555555 ^ (0x55555555 - n);
            if (val == 0) {
                return "0";
            }
            StringBuilder res = new StringBuilder();
            while (val != 0) {
                res.append(val & 1);
                val >>= 1;
            }
            return res.reverse().toString();
        }
    }



}
