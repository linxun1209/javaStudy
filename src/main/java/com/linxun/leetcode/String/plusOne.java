package com.linxun.leetcode.String;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.String
 * @date 2022/11/29 15:58
 */
public class plusOne {
    public static void main(String[] args) {
        int[] digits={1,2,3};
        plusOne(digits);
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

