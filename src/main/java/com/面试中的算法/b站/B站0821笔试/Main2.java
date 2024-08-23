package com.面试中的算法.b站.B站0821笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/21 19:58
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n = scanner.next();
        int m = scanner.nextInt();

        Set<Long> divisibleNumbers = new HashSet<>();

        permuteAndCheck("", n, m, divisibleNumbers);

        System.out.println(divisibleNumbers.size());

        scanner.close();
    }

    public static void permuteAndCheck(String prefix, String str, int m, Set<Long> divisibleNumbers) {
        int n = str.length();
        if (n == 0) {
            long num = Long.parseLong(prefix);
            if (num % m == 0) {
                divisibleNumbers.add(num);
            }
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndCheck(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), m, divisibleNumbers);
            }
        }
    }

}

