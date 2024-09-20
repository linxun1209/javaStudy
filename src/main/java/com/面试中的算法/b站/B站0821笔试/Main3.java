package com.面试中的算法.b站.B站0821笔试;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/21 19:34
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        Stack<Integer> stack=new Stack<>();
        int max=0;
        int last=-1;
        for (int i = 0; i < n; i++) {
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    last=i;
                }else {
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i - last);
                    }else {
                        max=Math.max(max,i-stack.peek());
                    }
                }
            }
        }
        System.out.println(max);
        in.close();
    }

}

