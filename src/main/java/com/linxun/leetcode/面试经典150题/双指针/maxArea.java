package com.linxun.leetcode.面试经典150题.双指针;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 11. 盛最多水的容器
 * @date 2024/3/8 23:19
 */
public class maxArea {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1,res=0;
        while (i<j){
            res=height[i]<height[j]
                    ?
                    Math.max(res,(j-i)*height[i++])
                    :
                    Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            int minH = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            // 快速跳过这步可太妙了
            while (height[l] <= minH && l < r) {
                l++;
            }
            while (height[r] <= minH && l < r) {
                r--;
            }
        }
        return maxArea;

    }
}
