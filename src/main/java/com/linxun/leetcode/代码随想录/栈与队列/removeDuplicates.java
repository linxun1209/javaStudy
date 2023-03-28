package com.linxun.leetcode.代码随想录.栈与队列;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.栈与队列
 * @date 2023/3/28 20:33
 */
public class removeDuplicates {


    public static void main(String[] args) {
        String s="aabcc";
        removeDuplicates2(s);
    }

    public String removeDuplicates(String s) {
//        int len=s.length();
//        for(int i=0;i<len-1;i++){
//            if(s.charAt(i)==s.charAt(i+1)){
//
//            }
//        }
        String[] s1=s.split("");
        Stack<String> stack=new Stack<>();
        stack.push(s1[0]);
        for (int i=1;i<s1.length;i++){
            String res=stack.isEmpty()?"":s1[i];
            if(!s1[i].equals(res)){
                stack.push(s1[i]);
            }else{
                stack.pop();
            }
        }
        String ans="";

        while (!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }


    /**
     * StringBuilder
     * @param S
     * @return
     */
        public static String removeDuplicates2(String S) {
            char[] s = S.toCharArray();
            int top = -1;
            for (int i = 0; i < S.length(); i++) {
                if (top == -1 || s[top] != s[i]) {
                    s[++top] = s[i];
                } else {
                    top--;
                }
            }
            return String.valueOf(s, 0, top + 1);
        }


    /**
     * 栈
     *
     * @param s
     * @return
     */
    public String removeDuplicates3(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

}
