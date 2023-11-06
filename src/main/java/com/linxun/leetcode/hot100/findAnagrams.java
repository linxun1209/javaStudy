package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/25 21:07
 *
 * 滑动窗口第二题
 * 找到字符串中所以的字母异或词
 *
 */
public class findAnagrams {

    public static void main(String[] args) {
        String s="cbaebabacd";
        String b="abc";
        findAnagrams02(s,b);
    }


    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        //在长度为26的int数组target中存储字符串p中对应字符（a~z）出现的次数
        //如p="abc",则target为[1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        //如p="bbdfeee",则target为[0,2,0,1,3,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        //双指针构建滑动窗口原理：
        //1.右指针right先向右滑动并在window中存储对应字符出现次数
        //2.当左右指针间的字符数量（包括左右指针位置的字符）与p长度相同时开始比较
        //3.比较完成后，左右指针均向右滑动一位，再次比较
        //4.以后一直重复2、3，直到end指针走到字符串s的末尾
        int left = 0, right = 0;
        int[] window = new int[26];
        //构建一个与target类似的，存储了字符串s从left位置到right位置的窗口中字符对应出现次数的数组
        List<Integer> ans = new ArrayList<Integer>();
        while (right < s.length()) {
            window[s.charAt(right) - 'a']++;
            //每次右指针right滑动，字符串s的right位置的字符出现次数加1
            if (right - left + 1 == p.length()) {
                if (Arrays.equals(window, target)) {
                    ans.add(left);
                    //通过Arrays.equals方法，当window数组与target数组相等即为异或词
                }
                window[s.charAt(left) - 'a']--;
                //比较完成后，字符串s的left位置的字符出现次数减1（减1是因为左指针下一步要向右滑动）
                left++;
                //左指针向右滑动
            }
            right++;
            //右指针向右滑动
        }
        return ans;
    }





    // 滑动窗口 + 数组;维护数组内各个元素的数量，和p比较
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list =new ArrayList<>();
        int length = s.length();
        int length1 = p.length();
        if (length<length1){
            return list;
        }
        // 制造一个和p一样长的窗口,统计各自字符的数量
        int[] countS = new int[26];
        int[] countP = new int[26];
        for (int i = 0; i < length1; i++) {
            countP[p.charAt(i)-'a']++;
            countS[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(countP,countS)){
            list.add(0);
        }
        for (int i = length1; i < length; i++) {
            countS[s.charAt(i)-'a']++;
            countS[s.charAt(i-length1)-'a']--;
            // 移动左指针，因为长度为length1
            if (Arrays.equals(countP,countS)){
                list.add(i-length1+1);
                //起始索引，左指针被抛弃了，所以起始索引+1
            }
        }
        return list;

    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }

            List<Integer> ans = new ArrayList<Integer>();
            int[] count = new int[26];
            for (int i = 0; i < pLen; ++i) {
                ++count[s.charAt(i) - 'a'];
                --count[p.charAt(i) - 'a'];
            }

            int differ = 0;
            for (int j = 0; j < 26; ++j) {
                if (count[j] != 0) {
                    ++differ;
                }
            }

            if (differ == 0) {
                ans.add(0);
            }

            for (int i = 0; i < sLen - pLen; ++i) {
                if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                    --differ;
                } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                    ++differ;
                }
                --count[s.charAt(i) - 'a'];

                if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                    --differ;
                } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                    ++differ;
                }
                ++count[s.charAt(i + pLen) - 'a'];

                if (differ == 0) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }

    // 双指针；判断右指针要添加的数是不是多余的或者不需要的
    // 若是多于，那么这个窗口减小，左指针一直到把这个删掉；这里若右指针加入的值是需要的但多于，如果左指针移动一格，即左右相等，
    // 那么添加这个索引；移动多格，长度不够了,继续右移右指针，判断长度，扩大窗口
    // 若不需要多于，左指针会移动到右指针的位置，继续右指针右移扩大窗口
    // 所以窗口内字符都不多于，当总长度相等，那么添加索引
    public static List<Integer> findAnagrams02(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int length = p.length();
        int length1 = s.length();
        if (length>length1){
            return list;
        }
        int[] countP = new int[26];
        int[] countS = new int[26];
        for (int i = 0; i < length; i++) {
            countP[p.charAt(i)-'a']++;
        }
        int left =0,right =0;
        for (int i = 0; i < length1; i++) {

            if (++countS[s.charAt(i)-'a']>countP[s.charAt(i)-'a']){
                countS[s.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1 == length){
                list.add(left);
            }
        }
        return list;

    }
}
