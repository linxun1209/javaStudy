package com.linxun.leetcode.每日挑战;

import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/24 21:13
 */
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for (int i=1;i<=len;i++){
            for (String word:wordDict){
                int wordLen=word.length();
                if(i-wordLen>=0&&s.substring(i-wordLen,i).equals(word)){
                    dp[i]|=dp[i-wordLen];
                }

            }
        }
        return dp[len];

    }
}
