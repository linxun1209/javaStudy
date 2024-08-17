package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        while (testCases-- > 0) {
            int number = input.nextInt();
            boolean isPrime = true;

            for (int divisor = 2; divisor * divisor <= number; divisor++) {
                if (number % divisor == 0) {
                    System.out.println(divisor+"     hj  jh");
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(number);
            }
        }
    }
}
