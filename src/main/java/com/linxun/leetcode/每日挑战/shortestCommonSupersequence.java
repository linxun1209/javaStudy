package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/28 20:14
 */
public class shortestCommonSupersequence {
    public static void main(String[] args) {
        String s1="abac";
        String s2="cab";
        shortestCommonSupersequence(s1,s2);
    }




    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m; ++i) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int t1 = 0, t2 = 0;
        while (t1 < n && t2 < m) {
            if (str1.charAt(t1) == str2.charAt(t2)) {
                res.append(str1.charAt(t1));
                ++t1;
                ++t2;
            } else if (dp[t1 + 1][t2] == dp[t1][t2] - 1) {
                res.append(str1.charAt(t1));
                ++t1;
            } else if (dp[t1][t2 + 1] == dp[t1][t2] - 1) {
                res.append(str2.charAt(t2));
                ++t2;
            }
        }
        if (t1 < n) {
            res.append(str1.substring(t1));
        } else if (t2 < m) {
            res.append(str2.substring(t2));
        }
        return res.toString();
    }




    /**
     * LCS 求具体方案 + 构造
     *
     * 为了方便，我们令 str1 为 s1，str2 为 s2，并将两者长度记为 m 和 n
     *
     * 容易想到最终的方案必然是由三部分组成：两字符串的公共子序列（且必然是最长公共子序列）+ 两者剩余的字符部分（保持相对顺序）。
     * 假如二者的 LCS 长度为 k，那么 最终 s1 和 s2 的最短公共超序列 长度必然为 m + n - k
     *
     * 基于此，我们可以先使用对两者求 LCS，并在求具体方案时遵循：属于最长公共子序列的字符只添加一次，而特有于 s1 或 s2 的字符则独自添加一次。
     *
     * 求解 LCS ，经典范围动态规划
     *
     * 定义 f[i][j] 代表考虑 s1 的前 i 个字符[0:i-1]、考虑 s2 的前 j 的字符[0:j-1]，形成的最长公共子序列长度（为了方便，令下标从 1 开始）。
     *
     * f = new int[m+1][n+1]，初始时 s1 前 0 个字符 和 s2 的 lcs 为 0；s2 前 0 个字符和 s1 的 lcs 为 0；所以 f[0][...] = f[...][0] = 0
     *
     * 当有了「状态定义」之后，基本上「转移方程」就是呼之欲出：
     *
     * 若 s1[i-1] == s2[j-1] : f[i][j] = f[i−1][j−1] + 1。
     *          代表必然使用 s1[i] 与 s2[j] 时 LCS 的长度。(即 s1[i]、s2[j] 作出贡献)
     * 若 s1[i-1] != s2[j-1] : max(f[i−1][j],f[i][j−1])。
     *          代表必然不使用 s1[i]（但可能使用 s2[j]）时 和 必然不使用 s2[j]（但可能使用 s1[i]）时 LCS 的长度。
     *          （即 s1[i] 是 s1 特有字符， 不对 LCS 作出贡献；或 s2[j] 是 s2 特有字符，不对 LCS 作出贡献）
     *
     *
     * 当得到 f 数组后，我们就知道了 s1 和 s2 的 LCS 的长度 k = f[m][n]
     * 但是我们并不知道具体的 LCS 内容是什么，这是因为我们在 dp 的过程中每次只是做选择，保留最大值，却并未记录当前值来自于哪一个选择
     *
     * 但是，我们可以通过逆向思维反推出dp数组具体的决策路径，
     * 既然是反推，那么必然是从后往前对dp数组进行访问，恢复出 LCS 的逆序内容
     *
     * 比如 dp递推时有
     *      若 s1[i-1] == s2[j-1] : f[i][j] = f[i−1][j−1] + 1。
     *      若 s1[i-1] != s2[j-1] : f[i][j] = max(f[i−1][j],f[i][j−1])
     * 那么当 f 全部求解完毕后，我们反向遍历f，初始化 i = m， j = n
     *      如果 s1[i-1]==s2[j-1]，那么这个字符必然对 LCS 作出贡献，【保留这个字符】
     *                                 此时LCS剩下的内容必然在 s1[0:i-2] 和 s2[0:j-2] 范围，此部分对应的 dp 为 f[i-1][j-1]
     *                                 所以这个时候让 i--； j--，
     *      否则：
     *      如果 f[i][j] = f[i-1][j]，说明在正向迭代dp的时候，s1[i-1]并未作出贡献，也就是说 s1[i-1] 属于 s1 特有的字符
     *      如果 f[i][j] = f[i][j-1]，说明在正向迭代dp的时候，s2[j-1]并未作出贡献，也就是说 s2[j-1] 属于 s2 特有的字符
     *
     *
     * 遍历结束后发现 所有保留下来的字符就是 LCS 的逆序内容
     *
     *
     * 基于以上知识来求解本题目：
     *
     * 我们知道 ans 一定是 LCS (s1, s2) + 两者剩余的字符部分（保持相对顺序）。
     *
     * 并且我们已经会 从 f 反向推出 LCS 了，只需要往 LCS 中插入 s1、s2 各自独有的部分就行
     *
     * 实际上，这个过程可以在 反推f求解 lcs 的过程中一并完成，
     *      在 反推f 得到 lcs 时，lcs 的每一个字符都是在  s1[i-1]==s2[j-1] 处得到的，
     *      而 f[i][j] = f[i-1][j] 或者 f[i][j] = f[i][j-1] 处，都代表遇到了 s1[i-1] 这个 s1 独有的字符 或 s2[j-1] 这个 s2 独有的字符
     *      那么，我们像保留 lcs 的字符一样把它们也保留下来不就可以了吗？？？
     *
     *
     * 具体地，初始化 i = m，j = n，反向遍历 f，用 sb 保存最终答案
     *
     * while (i > 0 && j > 0):
     *      如果 s1[i-1]==s2[j-1]：    对于 lcs 的字符，只需要保留一次，sb.append(s1[i-1])
     *                                      然后 i--；j--，剩下内容在 s[0:i-2][0:j-2]，即 f[i-1][j-1] 求解
     *      如果 f[i][j] = f[i-1][j] ： s1[i-1]并未对lcs作出贡献，所以 s1[i-1] 属于 s1 特有的字符，保留下来，sb.append(s1[i-1])
     *                                      然后 i--；剩下内容在 s[0:i-2][0:j-1]，即 f[i-1][j] 求解
     *      如果 f[i][j] = f[i][j-1] ： s2[j-1]并未对lcs作出贡献，所以 s2[j-1] 属于 s2 特有的字符，保留下来，sb.append(s2[j-1])
     *                                      然后 j--；剩下内容在 s[0:i-1][0:j-2]，即 f[i][j-1] 求解
     *
     * 当 while 循环退出(i==0或j==0)时，
     *      如果 i == 0，说明 s2[0:j] 均为对 lcs 做出贡献，那么全部需要保留，
     *      如果 j == 0，说明 s1[0:i] 均为对 lcs 做出贡献，那么全部需要保留，
     *
     * 【注意】
     * 逆序恢复 lcs 时，为什么第一个判断条件是 s1[i-1]==s2[j-1] ，不能是 f[i][j] = f[i−1][j−1] + 1 呢？
     *      首先 如果 s1[i-1]==s2[j-1] 必然能得到 f[i][j] = f[i−1][j−1] + 1
     *      但是 如果 f[i][j] = f[i−1][j−1] + 1，不一定能得到 s1[i-1]==s2[j-1]，也有可能是 s1[i-1]!=s2[j-1]，
     *              f[i][j]来自于 f[i-1][j] 或 f[i][j-1]，恰好也满足 == f[i−1][j−1] + 1
     *
     *      所以，只有 s1[i-1]==s2[j-1] 时能保证这个字符一定属于 lcs
     *
     * 最后，由于我们是从后往前进行构造，在返回时需要再进行一次翻转。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode.cn/problems/shortest-common-supersequence/solution/by-ac_oier-s346/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence2(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        // f[i][j] 代表考虑 s1 的前 i 个字符[0:i-1]、考虑 s2 的前 j 的字符[0:j-1]，形成的最长公共子序列长度
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // 递推
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        // 逆序构造 得到 scs
        int i = m, j = n;
        // ans必然来自 lcs + s1、s2独有部分
        StringBuilder ans = new StringBuilder();
        // 从后往前
        while (i > 0 && j > 0) {
            // lcs字符,s1[i-1]和s2[j-1]均做出贡献
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // 保留当前字符，i，j指针均减小，之后搜索 s1[0:i-2],s2[0:j-2]
                ans.append(str2.charAt(j - 1));
                i--;
                j--;
                // s1[i-1]并未对 lcs 作出贡献，属于 s1 独有字符
            } else if (f[i][j] == f[i - 1][j]) {
                // 保留
                ans.append(str1.charAt(i - 1));
                // s1的指针i减小，
                i--;
                // s2[j-1]并未对 lcs 作出贡献，属于 s2 独有字符
            } else if (f[i][j] == f[i][j - 1]) {
                // 保留
                ans.append(str2.charAt(j - 1));
                // s2的指针i减小，
                j--;
            }
        }
        // s1[0:i-1]均未对lcs做出贡献，属于s1独有，全部保留
        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }
        // s2[0:j-1]均未对lcs做出贡献，属于s2独有，全部保留
        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }
        // 由于我们是从后往前进行构造，在返回时需要再进行一次翻转。
        return ans.reverse().toString();
    }
}
