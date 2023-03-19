package com.linxun.leetcode.awing每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.awing每日挑战
 * @date 2023/3/19 17:59
 */
public class longestPalindrome_05 {
    public static void main(String[] args) {
        String a="babad";
        longestPalindrome(a);
    }


    //主函数
    public static String longestPalindrome(String s) {
        //奇数
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            //奇数的时候
            //从i开始判断两边的是否是一样的,如果是的话继续,直到不是的时候
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (ans.length() < r - l - 1) {
                //根据上面的l和r对该字母进行切割,赋值给ans
                ans = s.substring(l + 1, r);
            }
            //此时把最左边的值赋给i
            //剩下r的继续+1
            //偶数的时候
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (ans.length() < r - l - 1) {
                ans = s.substring(l + 1, r);
            }


        }
        return ans;
    }
}
