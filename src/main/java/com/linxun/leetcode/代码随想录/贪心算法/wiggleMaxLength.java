package com.linxun.leetcode.代码随想录.贪心算法;

import java.util.ArrayList;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/4/22 10:49
 */
public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public int wiggleMaxLength2(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度
        int dp[][] = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++){
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;

            for (int j = 0; j < i; j++){
                if (nums[j] > nums[i]){
                    // i 是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (nums[j] < nums[i]){
                    // i 是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


    public int wiggleMaxLength3(int[] nums) {
    // 可贪心，可动态规划
    // dp[i] ,以i结尾的序列，最长摆动子序列的长度，值为dp[i]。
        if(nums == null || nums.length == 0) {
            return 0;
        }
    int n = nums.length;

    // 我们要避免平坡的情况，即数组去重。
    ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i = 1;i <n;i++){
        if(nums[i] != nums[i-1]) {
            arr.add(nums[i]);
        }
    }

    // 获取非重复元素数组的长度
    n = arr.size();
        if(n <= 2) {
            return n;
        }

    int[] dp = new int[n];
    // 根据题目描述，可对数组进行必要的初始化
    dp[0] = 1;
    dp[1] = 2;

        for(int i =2;i<n;i++){
        if( (arr.get(i) - arr.get(i-1)) * (arr.get(i-1) - arr.get(i-2)) < 0){
            //该数组与前一位的大小关系 与 前一位和前两位之间的大小关系是不同的
            dp[i] = dp[i-1] + 1;
            //以该数结尾的摆动序列长度可以根据上一位已经计算得到的值再+1
        }else{
            dp[i] = dp[i-1];
            // 摆动序列并没有延长
        }
    }
    // 由于值会不断传递，所以我们直接返回该数组的最后一位
        return dp[n-1];

}


    public int wiggleMaxLength4(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
