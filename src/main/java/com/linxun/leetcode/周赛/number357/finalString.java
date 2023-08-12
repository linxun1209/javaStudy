package com.linxun.leetcode.周赛.number357;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.周赛.number357
 * @date 2023/8/11 8:29
 */
public class finalString {
    public static void main(String[] args) {
        String s="string";
        finalString(s);
    }
    public static String finalString(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)!='i'){
                stringBuilder.append(s.charAt(i));
            }else {
                stringBuilder.reverse();
            }

        }
        return stringBuilder.toString();
    }

}
