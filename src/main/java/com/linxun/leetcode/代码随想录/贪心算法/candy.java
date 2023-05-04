package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/4 22:15
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
}
