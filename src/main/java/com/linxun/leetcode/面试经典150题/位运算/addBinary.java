package com.linxun.leetcode.面试经典150题.位运算;

import java.math.BigInteger;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/15 21:16
 */
public class addBinary {
    public static void main(String[] args) {
        addBinary2("11","1");
    }
    public String addBinary(String a, String b) {
        BigInteger b1 = new BigInteger(a, 2);
        BigInteger b2 = new BigInteger(b, 2);
        return b1.add(b2).toString(2);
    }

    public static String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


}

