package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 135. 分发糖果
 * @date 2024/3/5 20:31
 */
public class candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for(int i=0;i<candy.length;i++){
            candy[i]=1;
        }
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;

            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }

        }
        int count=0;
        for(int i=0;i<candy.length;i++){
            count+=candy[i];
        }
        return count;
    }



    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}

