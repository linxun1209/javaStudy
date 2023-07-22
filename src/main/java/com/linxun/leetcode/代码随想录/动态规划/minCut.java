package com.linxun.leetcode.代码随想录.动态规划;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/29 16:28
 */
public class minCut {
    public static void main(String[] args) {
        String s="aab";
        minCut(s);
    }

    public static int minCut(String s) {
            if(null == s || "".equals(s)){
                return 0;
            }
            int len = s.length();
            // 1.
            // 记录子串[i..j]是否是回文串
            boolean[][] isPalindromic = new boolean[len][len];
            // 从下到上，从左到右
            for(int i = len - 1; i >= 0; i--){
                for(int j = i; j < len; j++){
                    if(s.charAt(i) == s.charAt(j)){
                        if(j - i <= 1){
                            isPalindromic[i][j] = true;
                        } else{
                            isPalindromic[i][j] = isPalindromic[i + 1][j - 1];
                        }
                    } else{
                        isPalindromic[i][j] = false;
                    }
                }
            }

            // 2.
            // dp[i] 表示[0..i]的最小分割次数
            int[] dp = new int[len];
            for(int i = 0; i < len; i++){
                //初始考虑最坏的情况。 1个字符分割0次， len个字符分割 len - 1次
                dp[i] = i;
            }

            for(int i = 1; i < len; i++){
                if(isPalindromic[0][i]){
                    // s[0..i]是回文了，那 dp[i] = 0, 一次也不用分割
                    dp[i] = 0;
                    continue;
                }
                for(int j = 0; j < i; j++){
                    // 按文中的思路，不清楚就拿 "ababa" 为例，先写出 isPalindromic 数组，再进行求解
                    if(isPalindromic[j + 1][i]){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len - 1];
    }
}
