package com.xingchen;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen
 * @date 2022/8/28 14:17
 */
import java.util.Scanner;
import java.util.*;

class Test2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n=input.nextInt();
        int[][] arr=new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j]=input.nextInt();
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr));
        }


        input.close();
    }
}