package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/9 17:44
 */
public class subtractProductAndSum {
    public static void main(String[] args) {
        subtractProductAndSum(123);
    }
    public static int subtractProductAndSum(int n) {
        int X=1;
        int Y=0;
        while (n!=0){
            Y+=n%10;
            X*=n%10;
            n/=10;
        }
        return X-Y;



    }
}
