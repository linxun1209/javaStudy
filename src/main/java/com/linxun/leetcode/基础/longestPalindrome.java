package com.linxun.leetcode.基础;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.基础
 * @date 2022/11/3 15:48
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s="qwqwq";
        System.out.println(longestPalindrome(s));
    }
    //主函数
    public static String longestPalindrome(String s) {
        //奇数
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            int l=i-1;
            int r=i+1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;


            }
            if(ans.length()<r-l-1){
                ans=s.substring(l+1,r);
            }
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
}
