package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 58. 最后一个单词的长度
 * @date 2024/3/6 23:24
 */
public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                count++;

            }else if(count!=0){
                return count;
            }
        }
        return count;

    }
}

