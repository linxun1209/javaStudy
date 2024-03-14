package com.linxun.leetcode.面试经典150题.哈希表;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 242. 有效的字母异位词
 * @date 2024/3/14 22:08
 */
public class isAnagram {
    public boolean isAnagram(String s, String t) {
        int[] ans=new int[26];
        int temp=0;
        for(int i=0;i<s.length();i++){
            temp=s.charAt(i)-'a';
            ans[temp]++;
        }
        for(int j=0;j<t.length();j++){
            temp=t.charAt(j)-'a';
            ans[temp]--;
        }
        for(int i:ans){
            if(i!=0){
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}

