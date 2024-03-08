package com.linxun.leetcode.面试经典150题.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 383. 赎金信
 * @date 2024/3/8 23:43
 */
public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        //记录杂志字符串出现的次数
        int[] arr = new int[26];
        int temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i) - 'a';
            arr[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i) - 'a';
            //对于金信中的每一个字符都在数组中查找
            //找到相应位减一，否则找不到返回false
            if (arr[temp] > 0) {
                arr[temp]--;
            } else {
                return false;
            }
        }
        return true;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            String c = String.valueOf(ransomNote.charAt(i));
            if (magazine.contains(c)) {
                magazine = magazine.replaceFirst(c, "");
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 哈希
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct3(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        for (char c : str2) {
            int num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);
        }
        for (char c : str1) {
            if (map.containsKey(c)) {
                int num = map.get(c) - 1;
                if (num < 0)
                    return false;
                map.put(c, num);
            } else {
                return false;
            }
        }
        return true;
    }
}

