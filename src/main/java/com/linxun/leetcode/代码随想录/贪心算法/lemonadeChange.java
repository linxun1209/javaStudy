package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/4 22:23
 */
public class lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                ten++;
                five--;
            }else if(bills[i]==20){
                if(ten>0){
                    ten--;
                    five--;
                }else {
                    five-=3;
                }

            }if(five<0||ten<0){
                return false;
        }
        }
        return true;
    }
}
