package com.linxun.leetcode.代码随想录.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.动态规划
 * @date 2023/5/10 21:27
 */
public class numSquares {


//    任何正整数都可以拆分成不超过4个数的平方和 ---> 答案只可能是1,2,3,4
//    如果一个数最少可以拆成4个数的平方和，则这个数还满足 n = (4^a)*(8b+7) --->
//    因此可以先看这个数是否满足上述公式，如果不满足，答案就是1,2,3了
//    如果这个数本来就是某个数的平方，那么答案就是1，否则答案就只剩2,3了
//    如果答案是2，即n=a^2+b^2，那么我们可以枚举a，来验证，如果验证通过则答案是2
//            只能是3
    //第一个数字是4,后面的数也都是4的倍数,所以对4取余得到最少平方数
    public int numSquares(int n) {
        while(n % 4 == 0) {
            n /= 4;  //判4
        }
        if(n % 8 == 7) {
            return 4;
        }

        for(int i = 0; i * i <= n; ++i) {  //判1
            if(n - i * i == 0) {
                return 1;
            }
        }

        for(int i = 0; i * i < n; ++i) {   //判2
            for(int j = 0; j * j < n; ++j) {
                if(n - i * i - j * j == 0) {
                    return 2;
                }
            }
        }
        return 3;   //4、1、2，都不是，直接返回3
    }

    // 版本二， 先遍历背包, 再遍历物品
    public int numSquares3(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        // 初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        // 当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历背包
        for (int j = 1; j <= n; j++) {
            // 遍历物品
            for (int i = 1; i * i <= j; i++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }


    public int numSquares5(int n) {
        //完全背包问题，物品为1,4,9,……所有小于等于根号n的完全平方数
        //最理想情况下n就是完全平方数，n=(根号n)^2 + 0
        return method1(n);
    }
    public int method1(int n){
        //物品数组，所有小于等于n的完全平方数
        List<Integer> nums = new ArrayList<Integer>();
        int num = 1;
        while(num*num<=n){
            nums.add(num*num);
            num+=1;
        }
        int m = nums.size();//物品数量
        //dp[i][j]，在0到i个物品中选取，最少需要几个完全平方数表示j
        //放不下：dp[i][j]=dp[i-1][j]
        //放得下，选两种情况中更少的：放dp[i][j]=dp[i][j-nums[i]]+1，不放dp[i][j]=dp[i-1][j]
        int[][] dp = new int[m][n+1];
        for(int j=0;j<=n;j++){//初始化，只用物品0的情况
            if(j%nums.get(0)==0) dp[0][j] = j/nums.get(0);//整除nums[0]时，可以组成
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<=n;j++){
                if(j<nums.get(i)) dp[i][j] = dp[i-1][j];//放不下，继承
                else{//放得下，取不放和放中，更小的。dp[i][j-nums.get(i)]是因为可以重复选取
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-nums.get(i)]+1);
                }
            }
        }
        return dp[m-1][n];
    }
    
}
