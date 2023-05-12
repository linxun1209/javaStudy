package com.linxun.leetcode.代码随想录.动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/10 21:47
 */
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
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
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }

    private Set<String> set;
    private int[] memo;
    public boolean wordBreak3(String s, List<String> wordDict) {
        memo = new int[s.length()];
        set = new HashSet<>(wordDict);
        return backtracking(s, 0);
    }

    public boolean backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] == -1) {
            return false;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            // 拆分出来的单词无法匹配
            if (!set.contains(sub)) {
                continue;
            }
            boolean res = backtracking(s, i + 1);
            if (res) {
                return true;
            }
        }
        // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
        memo[startIndex] = -1;
        return false;
    }

}
