package com.linxun.leetcode.hot100;

import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for(int i = 1; i <= len; i++) {
            for(String word : wordDict) {
                int wordLen = word.length();
                if(i - wordLen >= 0 && s.substring(i - wordLen, i).equals(word))
                    dp[i] |= dp[i - wordLen];
            }
        }
        return dp[len];
    }




    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        //dp[i]:字符串前i个字符能否被正确拆分
        boolean[] dp = new boolean[n+1];
        dp[0] = true;//其实无意义
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //只要确定dp[j]是true,并且[j, i]这个区间的子串出现在字典里，那么dp[i]一定是true
                //每次构造字符串是到不了i的，因此dp[j]看到的是到j-1的字符,所以写成s.substring(j,i),而不是s.substring(j+1,i)
                if(wordDict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
