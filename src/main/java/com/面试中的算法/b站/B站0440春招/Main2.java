package com.面试中的算法.b站.B站0440春招;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String s = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        if ((n - k) % 2 != 0) {
            result.append(s.substring(k - 1)).append(s.substring(0, k -1));
        } else {
            result.append(s.substring(k - 1)).append(new StringBuilder(s.substring(0, k - 1)).reverse());
        }

        System.out.println(result.toString());
    }
}

