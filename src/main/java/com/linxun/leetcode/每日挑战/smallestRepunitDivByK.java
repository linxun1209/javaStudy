package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/10 22:28
 */
public class smallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        int p=0;
        for(int i=1;i<=k;i++){
            p=(p*10+1)%k;
            if(p==0){return i;}
        }
        return -1;
    }
}
