package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/4 21:45
 */
public class maxTotalFruits {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int max = 0;
            for (int i = 0, j = 0, sum = 0; i < fruits.length; sum -= fruits[i++][1]) {
                while (j < fruits.length && 2 * Math.max(startPos - fruits[i][0], 0) + Math.max(fruits[j][0] - startPos, 0) <= k) {
                    max = Math.max(max, sum += fruits[j++][1]);
                }
            }
            for (int i = 0, j = 0, sum = 0; i < fruits.length; sum -= fruits[i++][1]) {
                while (j < fruits.length && Math.max(startPos - fruits[i][0], 0) + 2 * Math.max(fruits[j][0] - startPos, 0) <= k) {
                    max = Math.max(max, sum += fruits[j++][1]);
                }
            }
            return max;
    }


    public int maxTotalFruits2(int[][] fruits, int startPos, int k) {
        // 滑动窗口 + 前缀和 + 二分
        // 原理 —— 从起点s走完某个区间[l,r]所需的最小步数ans等于：
        // 1、走完区间本身的步数r-l。
        // 2、加上起点s走到两个区间端点中较近的一个所需的步数Math.min(|s-l|, |s-r|)。
        // 3、无论s点在区间[l,r]内还是在区间外，都适用这一公式
        // s在区间内部，需先走到较近的一个端点，再回头从这一端点走到另一端点(整个区间)，期间重复走了起始到端点的短路。
        // s在区间外部，同样需要先走到与s同侧的较近端点，再走完整个区间，期间不必重复走某段路。
        // 果实区域为[left,right]，起点为s，求k步内能取得的最大果实数，可以套用上述公式，用滑窗的方式枚举水果区域的有效区间，计算可获得的水果数最大值。
        // 滑窗过程中累加窗口右边界r扩入的果实数，按上述公式判断起点s走完当前区间[l,r]所需的最小步数是否大于k，若大于k则无法到达，需要尝试收缩左边界l，直到s走完当前区间所需最小步数<=k时，说明可以在k步内达到，根据当前区间的果实总数更新max。
        int n = fruits.length;
        int l = 0, max = 0, sum = 0;
        for(int r = 0; r < n; ++r){
            sum += fruits[r][1];
            while(l <= r && (fruits[r][0] - fruits[l][0] + Math.min(Math.abs(startPos-fruits[r][0]), Math.abs(startPos-fruits[l][0])) > k)){
                sum -= fruits[l++][1];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
