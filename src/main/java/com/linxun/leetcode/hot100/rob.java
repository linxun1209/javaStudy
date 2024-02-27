package com.linxun.leetcode.hot100;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/22 13:23
 */
public class rob {
    public int rob(TreeNode root) {
       /*
        你是我见过最聪明的小偷
        */
        /*
        //递归思想（不要深入递归函数体，只需知道递归函数的功能，以及找到跳出递归的边界条件）
        //思路：
        //能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
        //与 抢劫该节点的左子树+抢劫该节点的右子树的和  的最大值
        //执行用时 1005ms  原因是出现了很多重复的计算，可使用动态规划解决
        if(root == null) return 0;
        int val = 0;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        return Math.max(rob(root.left) + rob(root.right),val + root.val);
        */

        //动态规划
        //思路：
        //定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
        //方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode r){
        //边界条件，r为null时，跳出
        if(r == null) {
            return new int[2];
        }
        //对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额.
        // left[0]则为不抢r.lrft可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额
        // 以下right[] 分析同理
        int[] left = helper(r.left);
        int[] right = helper(r.right);
        int[] res = new int[2];
        //计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        res[1] = r.val + left[0] + right[0];
        return res;
    }


    /**
     * memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得的最大收益
     */
    private int[] memo;

    /**
     * 方式一：记忆化搜索
     * ① 状态：考虑抢劫 nums[index...num.length） 这个范围内的所有房子
     * ② 状态转移：tryRob(n) = Max{rob(0) + tryRob(2), rob(1) + tryRob(3)
     ... rob(n-3) + tryRob(n-1), rob(n-2), rob(n-1)}
     */
    public int rob1(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) return 0;
        // 记忆化搜索可以避免重叠子问题的重复运算
        if (memo[index] != -1) return memo[index];
        // 下面是对状态转移方程的描述
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    /**
     * 方式二：动态规划从后往前
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        // dp[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
        int[] dp = new int[n];
        // 先考虑最简单的情况
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // dp[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值
            dp[i] = Math.max(nums[i] + (i + 2 >= n ? 0 : dp[i + 2]), nums[i + 1] + (i + 3 >= n ? 0 : dp[i + 3]));
        }
        return dp[0];
    }

    /**
     * 方式三：动态规划从前往后
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n == 0 ? 0 : nums[0];
        // dp[i] 表示抢劫 nums[0...i] 所能获得最大收益
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        return dp[n - 1];
    }
}
