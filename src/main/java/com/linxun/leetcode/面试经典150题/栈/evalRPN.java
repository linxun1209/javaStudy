package com.linxun.leetcode.面试经典150题.栈;

import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 150. 逆波兰表达式求值
 * @date 2024/3/27 8:14
 */
public class evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        String operaters = "+-*/";
        for(String string : tokens){
            if(!operaters.contains(string)){
                s.push(Integer.valueOf(string));
                continue;
            }
            int b = s.pop();
            int a = s.pop();
            if(string .equals("+")){
                s.push(a + b);
            }else if(string.equals("-")){
                s.push(a - b);
            }else if(string.equals("*")){
                s.push(a * b);
            }else {
                s.push(a / b);
            }
        }
        return s.pop();
    }

    public int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }

}

