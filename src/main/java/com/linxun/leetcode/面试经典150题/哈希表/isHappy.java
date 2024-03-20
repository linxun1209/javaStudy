package com.linxun.leetcode.面试经典150题.哈希表;

import java.util.HashSet;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 202快乐数
 * @date 2024/3/15 16:58
 */
public class isHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set= new HashSet<>();
        while(n!=1){
            if(!set.contains(n)){
                set.add(n);
            }
            else return false;
            n = calculate(n);
        }
        return true;
    }

    //如果不会有1那么这个计算会一直重复下去
    private int calculate(int n){
        int res = 0;
        while(n>0){
            int remainder = n%10;
            res = res+remainder*remainder;
            n = n/10;
        }
        return res;
    }
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    /**
     * 快慢指针
     * 如果相遇则意味着不是快乐数
     * 如果没有相遇则意味着是快乐数，并且快指针先遇到1
     *
     * @param n
     * @return
     */

    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
