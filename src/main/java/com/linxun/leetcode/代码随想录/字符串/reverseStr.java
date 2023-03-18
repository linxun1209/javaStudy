package com.linxun.leetcode.代码随想录.字符串;

import com.xingchen.StringBuffer.reverse;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.哈希表
 * @date 2022/10/23 21:08
 */
public class reverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2*k) {
            if(i+k<=chars.length){
                reverse(chars,i,i+k);
            }
            reverse(chars,i,chars.length);

        }
        return new String(chars);

    }
    public void reverse(char[] chars,int i,int j){
        for (;i<j;i++,j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
