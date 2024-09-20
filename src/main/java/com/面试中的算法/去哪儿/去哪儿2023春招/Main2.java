package com.面试中的算法.去哪儿.去哪儿2023春招;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/6 18:27
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] as = scanner.nextLine().split(" ");

        Arrays.sort(as, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        for (String str : as) {
            System.out.printf("%s ", str);
        }
    }
}

