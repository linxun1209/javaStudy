package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/6 22:03
 */
public class monotoneIncreasingDigits {
    public static void main(String[] args) {
        int n=332;
        monotoneIncreasingDigits(n);
    }
    /**
     * 思路：
     *  从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     *  则把其左边一位数字减1，并将该位及其右边的所有位改成9
     */
    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        char[] chars = s.toCharArray();
        int flag = length;
        for (int i = length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));

    }
}
