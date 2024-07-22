package com.linxun.leetcode.算法复习.第一次刷到的算法题;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 2068. 检查两个字符串是否几乎相等
 * @date 2024/7/22 9:01
 */
public class checkAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (Math.abs(count[i]) > 3) {
                return false;
            }
        }
        return true;

    }


    public boolean checkAlmostEquivalent2(String word1, String word2) {
        // 数据量有限 用数组代替哈希表就行
        int[] hash = new int[26];
        for(char w1 : word1.toCharArray())
            hash[w1-'a']++;
        for(char w2 : word2.toCharArray())
            hash[w2-'a']--;
        for(int count : hash)
            if(Math.abs(count) > 3)
                return false;
        return true;
    }
}

