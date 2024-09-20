package com.面试中的算法.好未来;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/9/10 18:31
 */
public class Main2 {
    public int tribonacci (int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int t0=0,t1=1,t2=1;
        int tn=0;
        for(int i=3;i<=n;i++){
            tn=t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=tn;
        }

        return tn;
        // write code here
    }
}

