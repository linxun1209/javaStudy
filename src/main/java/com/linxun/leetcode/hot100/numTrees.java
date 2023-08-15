package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/15 19:25
 */
public class numTrees {
    /**
     *  对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
     * 一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n==1||n==2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            for (int j=0;i<i;j++){
                dp[i]+=dp[i-j-1]*dp[j];
            }
        }
        return dp[n];
    }
}
