package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/24 15:44
 */
public class countSubstrings {
    public static void main(String[] args) {
        String s="abc";
        countSubstrings2(s);
    }



    public static int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        //dp[i][j]标识i~j序列是否为回文串
        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)，依赖于dp矩阵中下一行左一列的结果
        //因此从下往上，从左往右进行遍历
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1;i >= 0; --i){
            //i<=j才是合法子串范围
            for(int j = i;j < n; ++j){
                if(s.charAt(j) == s.charAt(i)){
                    //i~j长度为1必为回文，长度为2时i、j位置字符相等即回文
                    if(j - i <= 1){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]) {
                    ++ans;
                }
            }
        }
        return ans;

    }


    /**
     * 中间扩展法
     * 思路:
     * 先找到中间位置然后分别依此向两边扩散
     * 直到遍历完成
     *
     * @param s
     * @return
     */
    public static int countSubstrings2(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }







}
