package com.linxun.leetcode.面试经典150题.双指针;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 392. 判断子序列
 * @date 2024/3/7 20:18
 */
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }


    public boolean isSubsequence2(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[][] dp=new int[len1+1][len2+1];
        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        if(dp[len1][len2]==len1){
            return true;
        }else {
            return false;
        }
    }

}

