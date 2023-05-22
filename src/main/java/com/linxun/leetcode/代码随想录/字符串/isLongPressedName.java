package com.linxun.leetcode.代码随想录.字符串;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.字符串
 * @date 2023/5/22 22:57
 */
public class isLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int len_n = name.length();
        int len_t = typed.length();
        if(len_n>len_t){
            return false;
        }
        int i=0;
        int j=0;
        while(i<len_n&&j<len_t){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        while(j<len_t){ //t 有剩余
            if(typed.charAt(j)!=typed.charAt(j-1)) {
                return false;
            }
            j++;
        }
        return i ==len_n;
    }



    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int i = 0, j = 0;
            int m = name.length(), n = typed.length();
            while (i< m && j < n) {
                if (name.charAt(i) == typed.charAt(j)) {  // 相同则同时向后匹配
                    i++; j++;
                }
                else {
                    if (j == 0) {
                        return false; // 如果是第一位就不相同直接返回false
                    }
                    // 判断边界为n-1,若为n会越界,例如name:"kikcxmvzi" typed:"kiikcxxmmvvzzz"
                    while (j < n-1 && typed.charAt(j) == typed.charAt(j-1)) {
                        j++;
                    }
                    if (name.charAt(i) == typed.charAt(j)) {  // j跨越重复项之后再次和name[i]匹配
                        i++; j++; // 相同则同时向后匹配
                    }
                    else {
                        return false;
                    }
                }
            }
            // 说明name没有匹配完
            if (i < m) {
                return false;
            }
            // 说明type没有匹配完
            while (j < n) {
                if (typed.charAt(j) == typed.charAt(j-1)) {
                    j++;
                } else {
                    return false;
                }
            }
            return true;
        }
    }}
