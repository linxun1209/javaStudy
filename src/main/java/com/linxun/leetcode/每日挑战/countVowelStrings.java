package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/29 13:16
 */
/**
 * 当 n 增加一个长度，对于已有的所有组合结果：
 * 以 a e i o u 开头的，都可以再以 a 开头
 * 以   e i o u 开头的，都可以在以 e 开头
 * ......
 */
class Solution {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for(int k = 1; k < n ; k++){
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;
    }
}
/**
 * 题解区的排列组合算法好牛。
 * 对于题目要求长度为 n 的答案来说：
 *【如果 a e i o u 的数目确定，排序方式是唯一的】
 * 这样问题就转化成，一个长为 n 的字符串，划分成 5 段，能划分多少种
 * 由于每个元素都可能是 0 个，所以各个划分位置可以都在 n 的外面
 * C(n+4, 4)
 */
class Solution2 {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}


/**]
 * 动态规划
 *
 */
class Solution3 {
    public int countVowelStrings(int n) {
        if(n==0) {
            return 0;
        }
        int[] dp = {1,1,1,1,1};
        for(int i=2;i<=n;i++){
            for(int j = 0;j<5;j++){
                for(int k =j+1;k<5;k++){
                    dp[j]+=dp[k];
                }
            }
        }
        return dp[0]+dp[1]+dp[2]+dp[3]+dp[4];
    }
}
