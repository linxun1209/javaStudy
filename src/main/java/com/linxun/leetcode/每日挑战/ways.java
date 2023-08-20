package com.linxun.leetcode.每日挑战;



import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/17 17:21
 */
public class ways {
    private int row, col;
    // 缓存
    private long[][][] memo;
    static final int N = (int) (1e9 + 7);
    // 二维前缀和数组
    private int[][] preSum;
    // 一个有多少苹果
    private int total;

    public int ways(String[] pizza, int k) {
        row = pizza.length;
        col = pizza[0].length();
        preSum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
                if (pizza[i].charAt(j) == 'A') {
                    preSum[i + 1][j + 1]++;
                }
            }
        }
        total = preSum[row][col];
        memo = new long[row][col][k];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) dfs(0, 0, k - 1, 0);
    }
    /**
     *
     * @param x 已切割横轴 x
     * @param y 已切割纵轴
     * @param k 仍需切割次数
     * @param lostSum 已经切割掉了的 苹果数
     * @return
     */
    private long dfs(int x, int y, int k, int lostSum) {
        if (memo[x][y][k] != -1) {
            return memo[x][y][k];
        }
        if (total < lostSum + k + 1) {
            return 0;// 不可完成
        }
        if (k == 0) {
            return lostSum < total ? 1 : 0;// 是否有剩余苹果,有+1
        }
        long xs = dfsX(x, y, k, lostSum) % N;
        long ys = dfsY(x, y, k, lostSum) % N;
        return memo[x][y][k] = (xs + ys) % N;
    }

    private long dfsX(int x, int y, int k, int lostSum) {
        if (k == 0) {
            return 0;
        }
        int tot = 0;
        for (int i = x + 1; i < row; i++) {
            // 可以进行 x 切割
            int splitXCnt = splitX(x, y, i);
            if (splitXCnt > 0) {
                // 可以切割
                tot += dfs(i, y, k - 1, lostSum + splitXCnt);
                tot %= N;
            }
        }
        return tot;
    }

    private long dfsY(int x, int y, int k, int lostSum) {
        if (k == 0) {
            return 0;
        }
        int tot = 0;
        for (int i = y + 1; i < col; i++) {
            // 可以进行 u 切割
            int splitYCnt = splitY(x, y, i);
            if (splitYCnt > 0) {
                // 可以切割
                tot += dfs(x, i, k - 1, lostSum + splitYCnt);
                tot %= N;
            }
        }
        return tot;
    }

    // 切割
// x切的末尾 + y 切的末尾 - (x,y)交点 = 被切割的点
// p[row][col] - 被切割的点数 = 剩余点数
    private int splitX(int x, int y, int cx) {
        int old = preSum[row][col] - (preSum[x][col] + preSum[row][y] - preSum[x][y]);
        int now = preSum[row][col] - (preSum[cx][col] + preSum[row][y] - preSum[cx][y]);
        return old - now;
    }

    private int splitY(int x, int y, int cy) {
        int old = preSum[row][col] - (preSum[x][col] + preSum[row][y] - preSum[x][y]);
        int now = preSum[row][col] - (preSum[x][col] + preSum[row][cy] - preSum[x][cy]);
        return old - now;
    }


    /**
     * 动态规划
     *
     * @param pizza
     * @param k
     * @return
     */
    public static int ways2(String[] pizza, int k) {
        int m=pizza.length,n=pizza[0].length(),mod=1_000_000_007;
        int[][] apple=new int[m+1][n+1];
        int[][][] dp=new int[k+1][m+1][n+1];
        for (int i=m-1;i>=0;i--){
           for (int j=n-1;j>=0;j--){
               apple[i][j]=(pizza[i].charAt(j)=='A'?1:0)+apple[i][j+1]+apple[i+1][j]-apple[i][j];
               dp[1][i][j]=apple[i][j]>0?1:0;
           }
       }
       for (int ki=2;ki<=k;ki++){
           for (int i=0;i<m;i++){
               for (int j=0;j<n;j++){
                   //水平方向切割
                   for (int i2=i+1;i2<m;i2++){
                       if(apple[i][j]>apple[i2][j]){
                           dp[ki][i][j]=(dp[k][i][j]+dp[ki-1][i2][j])%mod;
                       }
                   }
                   //竖直方向切割
                   for (int j2=j+1;j2<n;j2++){
                       if(apple[i][j]>apple[i][j2]){
                           dp[ki][i][j]=(dp[ki][i][j]+dp[ki-1][i][j2])%mod;
                       }
                   }
               }
           }

       }
       return dp[k][0][0];

    }

    public static void main(String[] args) {
        String[] pizza={"A..","AAA","..."};
        int k=3;
        ways2(pizza,k);


    }
}
