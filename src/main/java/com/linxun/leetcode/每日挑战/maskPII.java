package com.linxun.leetcode.每日挑战;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/1 18:59
 */
public class maskPII {
    public static void main(String[] args) {

    }





        public static String maskPII(String s) {
            String[] country = {"", "+*-", "+**-", "+***-"};
            int at = s.indexOf("@");
            if (at > 0) {
                s = s.toLowerCase();
                return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
            }
            s = s.replaceAll("[^0-9]", "");
            return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
        }





    public String maskPII2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean isDigit = false;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                left = i;
                isDigit = true;
                break;
            } else if (Character.isLetter(s.charAt(i))) {
                break;
            } else {
                continue;
            }
        }
        // 是电话号码
        if (isDigit) {
            int count = 0;
            for (int i = s.length() - 1; i >= 0 ; i--) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    if (count < 4) {
                        stack.offerFirst(c);
                    } else {
                        stack.offerFirst('*');
                    }

                    count++;
                    if (i > left && (count == 4 || count == 7 || count == 10)) {
                        stack.offerFirst('-');
                    }
                }
            }
            if (count > 10) {
                stack.offerFirst('+');
            }
        } else { // 是邮箱
            stack.offerLast(toLow(s.charAt(0)));
            boolean vi = false;
            for (int i = 0; i < 5; i++) {
                stack.offerLast('*');
            }
            for (int i = 0; i < s.length(); i++) {
                if (!vi && s.charAt(i + 1) != '@') {
                    continue;
                }
                if (i < s.length() - 1 && s.charAt(i + 1) == '@') {
                    vi = true;
                    stack.offerLast(toLow(s.charAt(i)));
                    continue;
                }
                stack.offerLast(toLow(s.charAt(i)));
            }
        }
        StringBuffer res = new StringBuffer();
        for (Character c : stack) {
            res.append(c);
        }
        return res.toString();
    }

    public char toLow(char c) {
        if (c >= 'A' && c <= 'Z') {
            c += 32;
        }
        return c;
    }
}
