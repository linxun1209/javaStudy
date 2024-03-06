package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 14. 最长公共前缀
 * @date 2024/3/6 23:28
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String s=strs[0];
        for(String string:strs){
            while(!string.startsWith(s)){
                if(s.length()==0) return "";
                s=s.substring(0,s.length()-1);

            }
        }
        return s;

    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}

