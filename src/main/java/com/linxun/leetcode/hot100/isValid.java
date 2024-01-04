package com.linxun.leetcode.hot100;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 17:56
 */
public class isValid {


    /**
     * 调api
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len=s.length()/2;
        for(int i=0;i<len;i++){
            s=s.replace("()","").replace("{}","").replace("[]","");

        }
        return s.length()==0;

    }


    /**
     * 栈
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();

    }


    public static void main(String[] args) {
        String s="([]{})";
        isValid2(s);
    }

    public static boolean isValid3(String s) {
        if(s.length()==0){
            return true;
        }
        Stack<Character> stack =new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char temp=stack.pop();
                    if(c==')'){
                        if(temp!='('){
                            return false;
                        }
                    }else if(c==']'){
                        if(temp!='['){
                            return false;
                        }
                    }else if(c=='}'){
                        if(temp!='{'){
                            return false;
                        }
                    }


                }

            }
        }
        return stack.isEmpty()?true:false;

    }
}
