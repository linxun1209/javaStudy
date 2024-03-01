package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/23 10:20
 */
public class longestPalindrome {
    //主函数
    public String longestPalindrome(String s) {
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            int l=i-1;
            int r=i+1;
            //奇数的时候
            //从i开始判断两边的是否是一样的,如果是的话继续,直到不是的时候
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(ans.length()<r-l-1){
                //根据上面的l和r对该字母进行切割,赋值给ans
                ans=s.substring(l+1,r);
            }
            //此时把最左边的值赋给i
            //剩下r的继续+1
            //偶数的时候
            l=i;
            r=i+1;

            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            if(ans.length()<r-l-1){
                ans=s.substring(l+1,r);
            }
        }
        return  ans;
    }



    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 中心扩展算法
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    /**
     * 将字符串倒叙，然后取交集
     * @param s
     * @return
     */
    public String longestPalindrome4(String s) {

        int length = s.length();
        String maxStr="";
        String reverse=new StringBuffer(s).reverse().toString();

        int x=0;
        int y=1;
        while (x<length&&y<=length){
            String substring = s.substring(x, y);
            if (reverse.contains(substring)){
                if(substring.equals(new StringBuffer(substring).reverse().toString()))
                    if (substring.length()>maxStr.length()){
                        maxStr=substring;
                    }
                y++;
            }else {
                x++;
                y=x+1;
            }
        }

        return maxStr;
    }

}
