package com.linxun.leetcode.面试经典150题.栈;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 224. 基本计算器
 * @date 2024/3/27 8:26
 */
public class calculate {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }


    public int calculate2(String s) {
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        // 存放所有的操作，包括 +/-
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && isNum(cs[j])) u = u * 10 + (int)(cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    while (!ops.isEmpty() && ops.peekLast() != '(') calc1(nums, ops);
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) calc1(nums, ops);
        return nums.peekLast();
    }
    void calc1(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }
    boolean isNum(char c) {
        return Character.isDigit(c);
    }


    /**
     *
     *如果在此基础上，再考虑 * 和 /，需要增加什么考虑？如何维护运算符的优先级？
     */
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};
    public int calculate3(String s) {
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty() && ops.peekLast() != '(') calc(nums, ops);
        return nums.peekLast();
    }
    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = (int)Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.addLast(ans);
    }
    boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    public int calculate4(String s) {
        /*
        参考评论区第一的思路:
        a)用一个变量res维护当前正在算的区块的和
        即若当前位置是位于()内的,res就是()内的和;如果是()外的,就是当前位置左边的和
        b)同时用一个变量sign维护当前操作符的正负
        1.遇到数字时,向右计算出完整的数字并追加到当前区块的和res中
        2.遇到"+"或"-"时,将符号位记录在sign中
        3.遇到"("时,表明重新开始了一个区块,先记录之前区块的res和sign进栈,然后res置0,sign置1,开始重新计算新区块的值
        4.遇到")"时,标志着该区块结束,将当前()内区块的res*sign追加到栈顶保存的旧的res中
        由于计算到最后,所在区块必定是整个式子,因此直接返回res即可
        */
        int res = 0, sign = 1;
        // stack用来保存之前区块的和以及新区块的符号
        Stack<Integer> stack = new Stack<>();
        // 去除空格
        s = s.replaceAll(" ", "");
        // 若去除空格后再遍历,len要取去除后的值
        // 也可以遍历的时候直接忽略' '的情况,例如遇到' '就continue;抑或if里面判断时直接忽略掉' '的情形
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                // s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'来判断也可以
                // 1.遇到数字:向右计算完整数字并追加到res中
                // cur是当前完整数字
                int cur = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                // 追加到res中(别漏了符号)
                res += cur * sign;
            }else if(c == '+' || c == '-'){
                // 2.遇到操作符:更新sign
                sign = c == '+' ? 1 : -1;
            }else if(c == '(') {
                // 3.遇到'(':记录并重置res与sign
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else {
                // 4.遇到')':计算当前区块的和并追加到res
                // 这里的stack.pop() * res是当前区块 * 栈中保存的当前区块的符号:-(1+2)
                // 后面的stack.pop()是之前的res的值:当前区块外的值
                // 两者加上就是算上()后的总的区块的和
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}

