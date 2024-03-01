package com.linxun.leetcode.hot100;

public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= text1.length() ; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }



    public int longestCommonSubsequence2(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // 多从二维dp数组过程分析
        // 关键在于  如果记录  dp[i - 1][j - 1]
        // 因为 dp[i - 1][j - 1]  <!=>  dp[j - 1]  <=>  dp[i][j - 1]
        int [] dp = new int[n2 + 1];

        for(int i = 1; i <= n1; i++){

            // 这里pre相当于 dp[i - 1][j - 1]
            int pre = dp[0];
            for(int j = 1; j <= n2; j++){

                //用于给pre赋值
                int cur = dp[j];
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    //这里pre相当于dp[i - 1][j - 1]   千万不能用dp[j - 1] !!
                    dp[j] = pre + 1;
                } else{
                    // dp[j]     相当于   dp[i - 1][j]
                    // dp[j - 1] 相当于   dp[i][j - 1]
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                //更新dp[i - 1][j - 1], 为下次使用做准备
                pre = cur;
            }
        }

        return dp[n2];
    }
}
