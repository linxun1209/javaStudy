package com.linxun.leetcode.代码随想录.动态规划;

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
    public int numSquares2(int n) {
        int max=Integer.MAX_VALUE;
        int[] dp=new int[n+1];

        for (int i=0;i<dp.length;i++){
            dp[i]=max;
        }
        dp[0]=0;
        for(int i=1;i*i<=n;i++){
            for (int j=i*i;j<=n;j++){
                if (dp[j-i*i]!=max){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }

            }
        }
        return dp[n];
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

}
