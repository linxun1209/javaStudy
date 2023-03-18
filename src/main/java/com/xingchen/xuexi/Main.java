package com.xingchen.xuexi;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.xuexi
 * @date 2022/9/4 14:21
 */
import java.util.Scanner;
import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long n = input.nextLong();

        for (int i = 0; i < n; i++) {
            long m= input.nextLong();
            System.out.println(isTrue(m));


        }





    }
    public static String isTrue(long n) {
        if (n == 1) {
            return "NO";
        }
        long l = 1 ;

        long r = (long) (Math.sqrt (n * 1.0) + 5);
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (mid * mid <= n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (l * l == n) {
            return isPrime (l);
        } else if (r * r == n) {
            return isPrime (r);
        } else return "NO";
    }




    public static String isPrime(long N) {
        long maxn = Math.min (N - 1, (long) (Math.sqrt (N * 1.0) + 5));
        for (long i = 2; i <= maxn; i++) {
            if (N % i == 0) {
                return "NO";
            }
        }
        return "YES";
    }
}