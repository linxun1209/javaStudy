package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] rect = new String[n];
        for (int i = 0; i < n; i++) {
            rect[i] = in.nextLine();
        }
        //为了便于理解转化为二维数组
        int[][] rectInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rectInt[i][j] = rect[i].charAt(j) - '0';
            }
        }
        int[][] dp=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+rectInt[i-1][j-1];

            }
        }

        for (int k = 1; k <= n; k++) {
            if(k%2!=0){
                System.out.println(0);
                continue;
            }
            int ans=0;
            int target=(k*k)/2;
            for (int i = k; i <=n; i++) {
                for (int j = k; j <=n ; j++) {
                    int sum=dp[i][j]-dp[i-k][j]+dp[i][j-k]+dp[i-1][j-1];
                    if(sum==target){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
