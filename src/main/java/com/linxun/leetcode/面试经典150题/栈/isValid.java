package com.linxun.leetcode.面试经典150题.栈;

import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 20. 有效的括号
 * @date 2024/3/26 17:17
 */
public class isValid {
    public boolean isValid(String s) {
        int len=s.length()/2;
        for(int i=0;i<len;i++){
            s=s.replace("()","").replace("{}","").replace("[]","");

        }
        return s.length()==0;

    }

    public boolean isValid2(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();

    }


    public boolean isValid3(String s) {
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

