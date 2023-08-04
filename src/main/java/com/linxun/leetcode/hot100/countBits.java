package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/20 17:56
 */
public class countBits {
    public static void main(String[] args) {
        int i=5;
        countBits(i);
    }

    /**
     * //方法一：i & (i - 1)可以去掉i最右边的一个1（如果有）
     * //因此 i & (i - 1）是比 i 小的，而且i & (i - 1)的1的个数已经在前面算过了
     * //所以i的1的个数就是 i & (i - 1)的1的个数加上1
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        //注意要从1开始，0不满足
        for(int i = 1;i<= num;i++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }


    /**
     * 方法二：i >> 1会把最低位去掉，因此i >> 1
     *     也是比i小的，同样也是在前面的数组里算过。
     *     当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；
     *     当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for(int i = 0;i<= num;i++){
            res[i] = res[i >> 1] + (i & 1);  //注意i&1需要加括号
        }
        return res;
    }


    public int[] countBits3(int num) {
        int dp[] = new int[num+1];
        for (int i = 0; i <= num/2; i++) {
            dp[i*2] = dp[i];
            if(i*2+1 <= num) {
                dp[i * 2 + 1] = dp[i] + 1;
            }
        }
        return dp;
    }

}
